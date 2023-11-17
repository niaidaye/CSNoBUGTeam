package com.csnobugteam.java.homework.java_dsdb.day02;

/**
 * @auther cxw
 * @since 2023/11/10
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  1.存储一组学生。包括 姓名 年龄，总分，入学日期
 *  2.找出总分最高的学生？
 *  3.找出总分最低的学生
 *  4.求平均分
 *  5.删除低于平均分的学生
 *  6.找出2年内入学的学生。
 *  7.需要删除叫张三的学生
 *  8.删除年龄小于18的学生
 */
public class CollectionForStudent {
    public static void main(String[] args) {
        Collection<Student> list = new ArrayList<>();
        list.add(new Student("zs", 18, 85, "2023/11/9"));
        list.add(new Student("ls", 19, 75, "2020/9/9"));
        list.add(new Student("wu", 20, 65, "2021/11/10"));
        list.add(new Student("jt", 17, 88, "2022/2/9"));
        list.add(new Student("hj", 19, 89, "2019/3/9"));
        list.add(new Student("ax", 18, 83, "2023/5/9"));

        // 求最高分数的学生
        findMaxScoreStu(list);

        // 求最低分数的学生
        findMinScoreStu(list);

        // 求平均分
        double averageScore = averageScore(list);
        System.out.printf("平均分为：%.2f\n", averageScore);

        // 删除低于平均分的学生
        removeBelowScore(list, averageScore);

        // 查找2年内入学的学生
        Collection<?> oldStudent = findOldStudent(list);
        System.out.println("2年内入学的学生为：");
        System.out.println(oldStudent);

        // 删除叫张三的学生
        removeStudentZs(list);

        // 删除小于18岁的学生
        removeBelow18(list);


    }

    private static void removeBelow18(Collection<Student> list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.age < 18) {
                iterator.remove();
            }
        }
        System.out.println("删除后的集合为：");
        System.out.println(list);
    }

    private static void removeStudentZs(Collection<Student> list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if ("zs".equals(student.name)) {
                iterator.remove();
            }
        }
        System.out.println("删除后的集合为：");
        System.out.println(list);
    }

    private static Collection<?> findOldStudent(Collection<Student> list) {
        ArrayList<Student> oldStudentList = new ArrayList<>();
        Iterator<Student> iterator = list.iterator();
        // 创建一个Calendar对象用于日期的增减
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        // 获得当前日期
        Date curData = new Date();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            try {
                Date date = simpleDateFormat.parse(student.enterDate);
                cal.setTime(date);
                // 入学的日期加2年
                cal.add(Calendar.YEAR, 2);
                System.out.println(cal.getTime());
                if (cal.getTime().after(curData)) {
                    oldStudentList.add(student);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return oldStudentList;
    }

    private static void removeBelowScore(Collection<Student> list, double averageScore) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.score < averageScore) {
                iterator.remove();
            }
        }
        System.out.println("删除后的集合为：");
        System.out.println(list);
    }

    private static double averageScore(Collection<Student> list) {
        Iterator<Student> iterator = list.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            sum += student.score;
        }
        return sum / list.size();
    }

    private static void findMinScoreStu(Collection<Student> list) {
        double minScore = 100;
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.score < minScore) {
                minScore = student.score;
            }
        }
        System.out.println("总分最低的学生如下：");
        for (Student student : list) {
            if (student.score == minScore) {
                System.out.println(student);
            }
        }
    }

    private static void findMaxScoreStu(Collection<Student> list) {
        double maxScore = 0;
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.score > maxScore) {
                maxScore = student.score;
            }
        }
        System.out.println("总分最高的学生如下：");
        for (Student student : list) {
            if (student.score == maxScore) {
                System.out.println(student);
            }
        }
    }
}

class Student {
    String name;
    int age;
    double score;
    String enterDate;

    public Student(String name, int age, int score, String enterDate) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.enterDate = enterDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", enterDate='" + enterDate + '\'' +
                '}';
    }
}
