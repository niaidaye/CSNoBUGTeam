package com.csnobugteam.java.homework.java_dsdb.day06;

import org.junit.Test;

import java.util.TreeMap;

/**
 * "aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
 * @auther cxw
 * @since 2023/11/15
 */
public class CharCountTest {
    @Test
    public void charCountTest() {
        String str = "aababcabcdabcde";
        TreeMap<Character, Integer> treeMap = new TreeMap<>(Character::compareTo);
        for (int i = 0; i < str.length(); i++) {
            // 第一种方式，利用getOrDefault方法
            //int count = treeMap.getOrDefault(str.charAt(i), 0);
            //treeMap.put(str.charAt(i), count + 1);

            // 第二种方式，利用containsKey方法，与第一种效果相同
            if (treeMap.containsKey(str.charAt(i))) {
                treeMap.put(str.charAt(i), treeMap.get(str.charAt(i)) + 1);
            } else {
                treeMap.put(str.charAt(i), 1);
            }
        }
        System.out.println(treeMap);
    }
}
