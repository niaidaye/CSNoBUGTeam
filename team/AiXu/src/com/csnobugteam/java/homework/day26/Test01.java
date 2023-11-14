package com.csnobugteam.java.homework.day26;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串s和t, 它们只包含小写字母。字符串t是由s中的字母随机打乱之后，
 * 在随机的一个位置添加一个字母生成的。请找出那个添加的字母。
 * 比如： s = "abcd" t = "baedc" 输出：e
 *
 * @author aixu
 * @since 2023/11/14
 */
public class Test01 {
    public String findAddedLetter(String s, String t) {
        StringBuilder res = new StringBuilder();
        // 创建一个Map
        Map<String, Integer> letterMap = new HashMap<>();
        // 遍历S字符串
        char[] charArrayS = s.toCharArray();
        for (char charS : charArrayS) {
            int count = letterMap.getOrDefault(String.valueOf(charS), 0);
            letterMap.put(String.valueOf(charS), ++count);
        }

        // 遍历t字符串
        char[] charArrayT = t.toCharArray();
        for (char charT : charArrayT) {
            int count = letterMap.getOrDefault(String.valueOf(charT), 0);
            letterMap.put(String.valueOf(charT), --count);
        }
        // 遍历Map
        Set<Map.Entry<String, Integer>> entries = letterMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() < 0) {
                res.append(entry.getKey());
            }
        }

        return res.toString();
    }
}
