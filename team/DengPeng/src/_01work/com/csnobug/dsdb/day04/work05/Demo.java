package _01work.com.csnobug.dsdb.day04.work05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/13 22:05
 */
/*
题目一：学生名单管理

假设你是一位老师，需要管理你班级的学生名单。请编写一个程序，使用ArrayList来实现学生名单的管理，包括添加学生、删除学生和显示学生名单。要求如下：

创建一个空的ArrayList对象来存储学生名单。
提示用户输入学生的姓名，并将其添加到学生名单中。
提供一个选项，允许用户从学生名单中删除某个学生。
提供一个选项，允许用户显示当前的学生名单。
提供一个选项，允许用户退出程序。
提示：使用Scanner类来接收用户输入。
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zs"));
        list.add(new Student("ls"));
        list.add(new Student("wu"));
        list.add(new Student("zl"));
        list.add(new Student("tq"));

        getMenu();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您的选择(1~4):");
            switch (scanner.nextInt()) {
                case 1:
                    addStuToList(list);
                    break;
                case 2:
                    delStuTolist(list);
                    break;
                case 3:
                    viewStuList(list);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("输入错误，请重新输入:");
                    break;
            }
        }
    }

    private static void viewStuList(ArrayList<Student> list) {
        System.out.println("学生名单如下:");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    private static void delStuTolist(ArrayList<Student> list) {
        System.out.println("请输入您需要删除学生的姓名:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (s.equals(iterator.next().name)) {
                iterator.remove();
            }
        }
        System.out.println("删除成功！");
    }

    private static void addStuToList(ArrayList<Student> list) {
        System.out.println("请输入需要新增的学生姓名:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        list.add(new Student(s));
        System.out.println("增加成功！");
    }

    private static void getMenu() {
        System.out.println("---------------欢迎来到学生管理系统---------------");
        System.out.println("-------------------1.增加学生-------------------");
        System.out.println("-------------------2.删除学生-------------------");
        System.out.println("------------------3.显示学生名单-----------------");
        System.out.println("-------------------4.退出程序-------------------");
    }
}

class Student {
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public Student(String name) {
        this.name = name;
    }
}
