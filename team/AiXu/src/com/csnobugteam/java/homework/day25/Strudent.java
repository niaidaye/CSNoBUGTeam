package com.csnobugteam.java.homework.day25;

/**
 * 学生对象
 *
 * @author aixu
 * @since 2023/11/13
 */
public class Strudent {
    private final String stuName;

    public Strudent(String stuName) {
        this.stuName = stuName;
    }

    public String getStuName() {
        return stuName;
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "stuName='" + stuName + '\'' +
                '}';
    }
}
