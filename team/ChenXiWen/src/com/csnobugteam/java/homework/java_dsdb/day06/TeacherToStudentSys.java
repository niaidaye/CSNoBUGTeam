package com.csnobugteam.java.homework.java_dsdb.day06;

import java.util.*;

/**
 * 一组学生数据，学生信息里有以下信息。
 * (id, name, age, teacher_id)
 * 一组班主任数据，有以下信息
 *  (id, name, age)
 *
 * 我们这样认为：一个老师对应n个学生，一个学生只对应一个老师。
 * 现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。
 * 提供两份数据：
 * List<Teacher> teachers = new ArrayList<>();
 * List<Student> students = new ArrayList<>();
 *
 * class Grade{
 * Teacher teacher;
 * List<Student> students;
 * }
 *
 * @auther cxw
 * @since 2023/11/15
 */
public class TeacherToStudentSys {
    public void TeacherToStudentTest() {
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        // key为老师的id，value为班级
        Map<String, Grade> map = getAllInfo(teacherList, studentList);
        // 可以通过班主任的id来获得该班级所有的同学
    }

    // 该方法返回一个按照 teacherId-班级 存储的HashMap
    public Map<String, Grade> getAllInfo(List<Teacher> teacherList, List<Student> studentList) {
        HashMap<String, Grade> map = new HashMap<>();
        // 存储学生信息
        for (Teacher teacher : teacherList) {
            List<Student> list = new ArrayList<>();
            Iterator<Student> iterator = studentList.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (teacher.id.equals(student.id)) {
                    list.add(student);
                }
            }
            map.put(teacher.id, new Grade(teacher, list));
        }
        return map;
    }
}

class Student {
    String id;
    String name;
    int age;
    String teacherId;

    public Student(String id, String name, int age, String teacherId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(teacherId, student.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, teacherId);
    }
}

class Teacher {
    String id;
    String name;
    int age;

    public Teacher(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && Objects.equals(id, teacher.id) && Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}

class Grade {
    Teacher teacher;
    List<Student> students;

    public Grade(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }
}