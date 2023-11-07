package com.csnobugteam.java.homework.day21.refract;

import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * 使用反射机制完成学生对象的创建并输出学生信息。
 * 要求：
 * （1）定义一个学生类Student，其中包含姓名(String)、年龄(int)、成绩(int)的属性。
 * （2）编写带参与无参构造方法。
 * （3）重写父类的toString()方法用于输出学生的信息。
 * （4）编写测试类TestStudent，从键盘录入学生的信息格式为(姓名:年龄:成绩)一次性录入使用“:”分隔，举例(张三:20:90)。
 * （5）使用String类的split方法按照“:”进行分隔。
 * （6）调用Constructor的newInstance()方法并用分隔后的信息初始化学生对象。
 * （7）调用重写父类的toString()方法将学生信息进入输出显示。
 * @author aixu
 * @since 2023/11/7
 */
class Student {
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "，年龄：" + age + "，成绩：" + score;
    }
}

public class TestStudent {
    public static void main(String[] args) {
        // 从键盘录入学生信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生信息（格式为姓名:年龄:成绩）：");
        String info = scanner.nextLine();

        // 使用“:”进行分隔
        String[] infoArray = info.split(":");

        try {
            // 获取Student类的Class对象
            Class<?> studentClass = Class.forName("com.csnobugteam.java.homework.day21.refract.Student");

            // 获取带参构造方法
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class, int.class);

            // 调用newInstance()方法创建学生对象
            Student student = (Student) constructor.newInstance(infoArray[0], Integer.parseInt(infoArray[1]), Integer.parseInt(infoArray[2]));

            // 输出学生信息
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}