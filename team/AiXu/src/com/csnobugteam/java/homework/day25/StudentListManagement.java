package com.csnobugteam.java.homework.day25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 学生名单管理
 * 假设你是一位老师，需要管理你班级的学生名单。请编写一个程序，使用ArrayList来实现学生名单的管理，包括添加学生、删除学生和显示学生名单。要求如下：
 * 创建一个空的ArrayList对象来存储学生名单。
 * 提示用户输入学生的姓名，并将其添加到学生名单中。
 * 提供一个选项，允许用户从学生名单中删除某个学生。
 * 提供一个选项，允许用户显示当前的学生名单。
 * 提供一个选项，允许用户退出程序。
 * 提示：使用Scanner类来接收用户输入。
 * @author aixu
 * @since 2023/11/13
 */
public class StudentListManagement {
    //创建一个空的ArrayList对象来存储学生名单

    private final List<Strudent> strudentList = new ArrayList<>();

    /**
     * 循环输入学生的姓名，并将其添加到学生名单中，直到输入0结束添加
     * @param name 学生姓名
     * @return true:添加成功。false
     */
    public boolean addStuByName(String name) {
        while (!"0".equals(name)) {
            try {
                strudentList.add(new Strudent(name));
            } catch (Exception e) {
                System.out.println("添加学生：" + name + "发生异常");
                return false;
            }
        }
        return true;
    }

    /**
     * 提供一个选项，允许用户从学生名单中删除某个学生。
     * @param strName 学生姓名
     * @return true/false
     */
    public boolean removeStuByName(String strName) {
        if (strudentList.isEmpty()) return false;
        else {
            // 使用lamber表达式进行，删除
            strudentList.removeIf(strudent -> strName.equals(strudent.getStuName()));

        }
        return true;
    }

    /**
     * 显示当前的学生名单
     */
    public void DisplaysCurrentStudentList() {
        strudentList.forEach(System.out::println);
    }


    public static void main(String[] args) {
        StudentListManagement studentListManagement = new StudentListManagement();
        Scanner scanner = new Scanner(System.in);

        // 添加学生
        System.out.println("请输入学生姓名，输入0结束添加：");
        String studentName;
        do {
            studentName = scanner.nextLine();
            if (!"0".equals(studentName)) {
                boolean success = studentListManagement.addStuByName(studentName);
                if (success) {
                    System.out.println("添加成功！");
                } else {
                    System.out.println("添加失败，请检查输入。");
                }
            }
        } while (!"0".equals(studentName));


        // 显示学生名单
        System.out.println("当前学生名单：");
        studentListManagement.DisplaysCurrentStudentList();

        // 删除学生
        System.out.println("请输入要删除的学生姓名：");
        String studentToRemove = scanner.next();
        boolean removeSuccess = studentListManagement.removeStuByName(studentToRemove);
        if (removeSuccess) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败，学生名单可能为空或未找到该学生。");
        }

        // 再次显示学生名单
        System.out.println("更新后的学生名单：");
        studentListManagement.DisplaysCurrentStudentList();
    }
}
