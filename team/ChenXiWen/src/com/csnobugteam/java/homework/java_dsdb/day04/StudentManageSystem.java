package com.csnobugteam.java.homework.java_dsdb.day04;

import org.junit.Test;

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
 * 说明：题目比较简单，不再添加额外注释
 * @auther cxw
 * @since 2023/11/13
 */
public class StudentManageSystem {

    @Test
    public void studentSystemStart() {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        // 设置一个loop来控制循环退出
        boolean loop = true;
        while (loop) {
            System.out.println("请输入一个选项(1-添加学生/2-删除学生/3-显示学生名单/4-退出程序):");
            String key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println("请输入学生姓名");
                    list.add(scanner.next());
                    break;
                case "2":
                    System.out.println("请输入要删除的学生姓名：");
                    list.remove(scanner.next());
                    break;
                case "3":
                    System.out.println("当前学生名单如下：");
                    printList(list);
                    break;
                case "4":
                    loop = false;
                    break;
                default:
                    System.out.println("您的输入有误！");
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }

    private static void printList(List<String> list) {
        for (String nameStr : list) {
            System.out.print(nameStr + " ");
        }
        System.out.println();
    }
}

