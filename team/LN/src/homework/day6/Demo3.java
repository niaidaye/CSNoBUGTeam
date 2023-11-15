package src.homework.day6;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/15
 */

/*
 一组学生数据，学生信息里有以下信息。
 (id, name, age, teacher_id)

 一组班主任数据，有以下信息
 (id, name, age)

 我们这样认为：一个老师对应n个学生，一个学生只对应一个老师。
 现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。
 提供两份数据：
 List<Teacher> teachers = new ArrayList<>();
 List<Student> students = new ArrayList<>();

class Grade{
Teacher teacher;
List<Student> students;
}
 */

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {

        // 创建一个 teacher数组，用于new 老师对象
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "t1", 30));
        teachers.add(new Teacher(2, "t2", 25));
        teachers.add(new Teacher(3, "t3", 40));


        // // 创建一个 student数组，用于new 学生对象
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "s1", 15, 1));
        students.add(new Student(2, "s2", 16, 1));
        students.add(new Student(3, "s3", 17, 2));
        students.add(new Student(4, "s4", 18, 2));


        // 创建一个 班级数组
        List<Grade> grades = new ArrayList<>();

        //遍历老师数组
        for (Teacher teacher : teachers) {

            // 创建一个与老师关联的学生数组
            List<Student> teacherStudent = new ArrayList<>();

            // 遍历学生数组
            for (Student student : students) {

                // 如果当前学生的老师 ID 与给定的老师 ID 相匹配的话
                if (student.getTeacherID() == teacher.getTeacherID()) {

                    // 就把学生加入到与老师关联的学生数组里
                    teacherStudent.add(student);

                }
            }

            Grade grade = new Grade(teacher, teacherStudent);
            grades.add(grade);
        }

        for (Grade grade : grades) {
            System.out.println(grade);

        }

    }
}


/*
定义了一个教师对应多个学生的类
有两个属性：
一个是老师类型的老师对象
一个是学生数组类型的一组学生
 */
class Grade {
    private Teacher teacher;
    private List<Student> students;


    /*
    有参构造器
     */
    public Grade(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    /*
    tostring 方法
     */
    @Override
    public String toString() {
        return "Grade{" +
                "teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}


/*
学生类：
属性
get set方法
tostring ：返回字符串的表示形式
 */
class Student {

    int studentID;

    String name;

    int age;

    int teacherID;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public Student(int studentID, String name, int age, int teacherID) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacherID=" + teacherID +
                '}';
    }
}


/*
老师类
属性
get set 方法
tostring
 */

class Teacher {
    int teacherID;

    String name;
    int age;

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher(int teacherID, String name, int age) {
        this.teacherID = teacherID;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


