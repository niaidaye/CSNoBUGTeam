package com.csnobugteam.java.homework.day23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1.存储一组学生。包括 姓名 年龄，总分，入学日期
 * 2.找出总分最高的学生？
 * 3.找出总分最低的学生
 * 4.求平均分
 * 5.删除低于平均分的学生
 * 6.找出2年内入学的学生。
 * 7.需要删除叫张三的学生
 * 8.删除年龄小于18的学生
 *
 * @author aixu
 * @since 2023/11/10
 */
public class ClassAndGrade {

    // 初始化学生
    public List<Student> init() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Student> classStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // 初始化并添加10个学生
            classStudents.add(
                    new Student("stu" + i, 15 + i, 60 + i, dateFormat.parse("2022-10-31")));
        }
        return classStudents;
    }

    // 2.找出总分最高的学生？
    public Student findMaxGrossScoreByStudentList(List<Student> studentList) {
        Student maxScoreStudent = new Student();
        maxScoreStudent.setGrossScore(-1);
        for (Student student : studentList) {
            if (student.getGrossScore() > maxScoreStudent.getGrossScore()) {
                maxScoreStudent = student;
            }
        }

        return maxScoreStudent;
    }

    // 3.找出总分最低的学生
    public Student findMinGrossScoreByStudentList(List<Student> studentList) {
        Student minScoreStudent = new Student();
        minScoreStudent.setGrossScore(999);
        for (Student student : studentList) {
            if (student.getGrossScore() < minScoreStudent.getGrossScore()) {
                minScoreStudent = student;
            }
        }
        return minScoreStudent;
    }

    // 4.求平均分
    public Double getAverByStudentList(List<Student> studentList) {
        double sum = 0;
        int count = 0;
        for (Student student : studentList) {
            sum += student.getGrossScore();
            count++;
        }
        return sum / count;
    }

    // 5.删除低于平均分的学生
    public void delStudentByAverDown(List<Student> studentList) {
        Double aver = getAverByStudentList(studentList);
        List<Student> newTempStu = new ArrayList<>();
        // 查找所有总分分数小于，平均分的学生
        for (Student student : studentList) {
            if (student.getGrossScore() < aver) {
                newTempStu.add(student);
            }
        }
        if (!newTempStu.isEmpty()) {
            for (Student student : newTempStu) {
                studentList.remove(student);
            }
        }

    }

    // 6.找出2年内入学的学生。
    public List<Student> findTowYearInStudent(List<Student> studentList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        List<Student> newTempStu = new ArrayList<>();
        for (Student student : studentList) {
            // 根据dateFormat取出学生入学的年，
            int year = Integer.parseInt(dateFormat.format(student.getDateOfEntrance()));
            // 找出2年内入学的学生。将学生添加到，newTempStu
            if (year > 2021) {
                newTempStu.add(student);
            }
        }
        return newTempStu;
    }

    // 7.需要删除叫张三的学生
    public List<Student> delStuByName(List<Student> studentList, String name) {
        List<Student> tempStus = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                tempStus.add(student);
            }
        }
        if (!tempStus.isEmpty()) {
            for (Student stus : tempStus) {
                // 移除满足条件的学生
                studentList.remove(stus);
            }
        }
        return studentList;
    }

    // 8.删除年龄小于18的学生
    public List<Student> delStuByAge(List<Student> studentList, int age) {
        List<Student> tempStus = new ArrayList<>();
        for (Student student : studentList) {
            // 判断是否有满足条件的学生
            if (student.getAge() == age) {
                tempStus.add(student);
            }
        }
        if (!tempStus.isEmpty()) {
            for (Student stus : tempStus) {
                // 移除满足条件的学生
                studentList.remove(stus);
            }
        }
        return studentList;
    }
}
// 学生对象
class Student{
    private String name;
    private int age;
    private int grossScore;
    private Date DateOfEntrance;

    public Student() {
    }

    public Student(String name, int age, int grossScore, Date dateOfEntrance) {
        this.name = name;
        this.age = age;
        this.grossScore = grossScore;
        DateOfEntrance = dateOfEntrance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grossScore=" + grossScore +
                ", DateOfEntrance='" + DateOfEntrance + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrossScore() {
        return grossScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrossScore(int grossScore) {
        this.grossScore = grossScore;
    }

    public Date getDateOfEntrance() {
        return DateOfEntrance;
    }

    public void setDateOfEntrance(Date dateOfEntrance) {
        DateOfEntrance = dateOfEntrance;
    }
}