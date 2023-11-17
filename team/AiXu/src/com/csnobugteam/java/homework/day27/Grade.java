package com.csnobugteam.java.homework.day27;

import java.util.List;
import java.util.Objects;

/**
 *  一组学生数据，学生信息里有以下信息。
 *  (id, name, age, teacher_id)
 *  一组班主任数据，有以下信息
 *  (id, name, age)
 *  我们这样认为：一个老师对应n个学生，一个学生只对应一个老师。
 *  现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。
 *  List<Teacher> teachers = new ArrayList<>();
 *  List<Student> students = new ArrayList<>();
 *  提供两份数据：
 * class Grade{ Teacher teacher; List<Student> students; }
 *
 * @author aixu
 * @since 2023/11/15
 */
public class Grade {
    private final Teacher teacher;
    private final List<Student> students;

    public Grade(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
// 老师类
class Teacher {
    private final int id;
    private final String name;
    private final int age;

    public Teacher(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getId() == teacher.getId() && age == teacher.age && Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, age);
    }
}
// 学生类
class Student {
    private int id;
    private String name;
    private int age;
    private int teacherId;

    public Student(int id, String name, int age, int teacherId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && getTeacherId() == student.getTeacherId() && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, getTeacherId());
    }
}