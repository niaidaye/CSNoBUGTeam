package src.homework.day4.homework;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/13
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Demo1 {

    /*
    假如我有一个ArrayList对象存储了一些数据, 如果我们想遍历这些数据, 可以通过哪些循环或者迭代来做？
    1：普通 for循环
    2：增强for循环
    3：迭代器

     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("ww");
        list.add("zl");

    // 普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }

    // 增强for循环
        for (String s : list) {
            System.out.println(s);

        }

    //迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }

    }

}






