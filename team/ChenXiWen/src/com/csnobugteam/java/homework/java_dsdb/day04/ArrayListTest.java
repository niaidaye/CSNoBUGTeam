package com.csnobugteam.java.homework.java_dsdb.day04;

import java.util.*;

/**
 * 假如我有一个ArrayList对象存储了一些数据, 如果我们想遍历这些数据, 可以通过哪些循环或者迭代来做
 * @auther cxw
 * @since 2023/11/13
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("ww");
        list.add("zl");
        // fori循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 普通迭代器
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        // ListIterator迭代器
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 增强for循环
        for (String s : list) {
            System.out.println(s);
        }
        // 转化为数组再遍历
        String[] array = (String[]) (list.toArray(new String[list.size()]));
        for (String s : array) {
            System.out.println(s);
        }
    }
}
