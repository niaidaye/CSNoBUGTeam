package _01work.com.csnobug.dsdb.day04.work02;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/13 21:28
 */
/*
假如我有一个ArrayList对象存储了一些数据, 如果我们想遍历这些数据, 可以通过哪些循环或者迭代来做
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("zs");
        arrayList.add("ls");
        arrayList.add("wu");
        arrayList.add("zl");
        arrayList.add("tq");

        // 方法1 for
        for (String s : arrayList) {
            System.out.print(s + "\t");
        }

        System.out.println("\n-----------------");

        // 方法2 fori
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "\t");
        }

        System.out.println("\n-----------------");

        // 方法3 iterator
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }

        System.out.println("\n-----------------");

        // 使用Java 8+中的Stream API：
        arrayList.stream().forEach(element -> System.out.print(element + "\t"));
    }
}
