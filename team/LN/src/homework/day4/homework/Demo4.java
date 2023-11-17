package src.homework.day4.homework;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/13
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
题目一：学生名单管理

假设你是一位老师，需要管理你班级的学生名单。请编写一个程序，
使用ArrayList来实现学生名单的管理，包括添加学生、删除学生和显示学生名单。
要求如下：
创建一个空的ArrayList对象来存储学生名单。
提示用户输入学生的姓名，并将其添加到学生名单中。
提供一个选项，允许用户从学生名单中删除某个学生。
提供一个选项，允许用户显示当前的学生名单。
提供一个选项，允许用户退出程序。
提示：使用Scanner类来接收用户输入
 */
public class Demo4 {
    public static void main(String[] args) {
        // 创建一个学生集合数组
        List<String> studentList = new ArrayList<>();
        // 定义用户键盘输入
        Scanner sc = new Scanner(System.in);
        // 死循环
        while (true) {
        // 定义学生名单管理界面
            System.out.println("=====学生名单管理系统=====");
            System.out.println("1：添加学生：");
            System.out.println("2：删除学生：");
            System.out.println("3：显示学生名单：");

            System.out.println("请选择操作（数字操作）：");
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    System.out.println("请输入要添加的学生：");
                    String studentName = sc.nextLine();
                // 创建一个添加学生的方法
                    addStudentName(studentList, studentName);
                    break;
                case 2:
                    System.out.println("请输入要删除的学生：");
                    String deleteStudent = sc.nextLine();
                // 创建一个删除学生的方法
                    removeStudent(studentList, deleteStudent);
                    break;
                case 3:
                // 创建一个查找学生名单的方法
                    displayStudentList(studentList);
                    break;
                case 4:
                // 程序退出
                    System.out.println("程序退出！！");
                    System.exit(0);
                default:
                    System.out.println("输入无效，请重新输入~~");
            }

        }


    }


    private static void displayStudentList(List<String> studentList) {
    // 遍历student学生数组，获取当前学生名单
        System.out.println("当前学生名单：");
        for (String student : studentList) {
            System.out.println(student);

        }
    }

    private static void removeStudent(List<String> studentList, String deleteStudent) {
    // 判断一下，如果学生数组里有重复的要删除的学生
        if (studentList.contains(deleteStudent)) {
    // 从学生数组里删除学生  remove
            studentList.remove(deleteStudent);
            System.out.println(deleteStudent + "已成功删除学生");
        } else {
            System.out.println("学生名单中不存在" + deleteStudent);
        }
    }

    private static void addStudentName(List<String> studentList, String studentName) {
    // 添加学生  add
        studentList.add(studentName);
        System.out.println(studentName + "已成功添加到学生名单");
    }
}

