package _01work.com.csnobug.dsdb.day06.work04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 一组学生数据，学生信息里有以下信息。
 * (id, name, age, teacher_id)
 * 一组班主任数据，有以下信息
 * (id, name, age)
 * 我们这样认为：一个老师对应n个学生，一个学生只对应一个老师。
 * 现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。
 * 提供两份数据：
 * List<Teacher> teachers = new ArrayList<>();
 * List<Student> students = new ArrayList<>();
 * class Grade{
 * Teacher teacher;
 * List<Student> students;
 * }
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/15 17:22
 */
public class Demo {
    @Test
    public void test1() {

        // 现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。

        //-----------------------------------------

        // 假设已经有了以下数据  数据初始化
        List<Teacher> teachers = getResultTeachers();
        List<Student> students = getResultStudents();

        // 组织数据
        List<Grade> grades = new ArrayList<>();

        for (Teacher teacher : teachers) {
            List<Student> classStudents = new ArrayList<>();

            for (Student student : students) {
                if (student.teacherId == teacher.teacherId) {
                    classStudents.add(student);
                }
            }

            Grade grade = new Grade(teacher, classStudents);
            grades.add(grade);
        }

        // 现在，grades 中包含了每个班主任和对应班级同学的信息
        System.out.println(grades);

    }

    private List<Teacher> getResultTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        Teacher teacher1 = new Teacher(77, "李老师", 29);
        Teacher teacher2 = new Teacher(88, "刘老师", 26);
        Teacher teacher3 = new Teacher(99, "赵老师", 34);

        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        return teachers;
    }

    private List<Student> getResultStudents() {

        List<Student> students = new ArrayList<>();

        Student student1 = new Student(7, "l1", 14, 77);
        Student student2 = new Student(17, "l2", 15, 77);
        Student student3 = new Student(27, "l3", 16, 77);
        Student student4 = new Student(8, "a1", 12, 88);
        Student student5 = new Student(18, "a2", 14, 88);
        Student student6 = new Student(28, "a3", 13, 88);
        Student student7 = new Student(9, "a3", 13, 99);
        Student student8 = new Student(19, "a3", 15, 99);
        Student student9 = new Student(29, "a3", 17, 99);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);

        return students;
    }
}

/*
 * 一组学生数据，学生信息里有以下信息。
 * (id, name, age, teacher_id)
 * 一组班主任数据，有以下信息
 * (id, name, age)
 */
class Student {
    int stuId;
    String stuName;
    int stuAge;
    int teacherId;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", teacherId=" + teacherId +
                '}';
    }

    public Student(int stuId, String stuName, int stuAge, int teacherId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.teacherId = teacherId;
    }
}

class Teacher {
    int teacherId;
    String teacherName;
    int teacherAge;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAge=" + teacherAge +
                '}';
    }

    public Teacher(int teacherId, String teacherName, int teacherAge) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
    }
}

class Grade{
    Teacher teacher;
    List<Student> students;

    @Override
    public String toString() {
        return "Grade{" +
                "teacher=" + teacher +
                ", students=" + students +
                '}';
    }

    public Grade(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }
}