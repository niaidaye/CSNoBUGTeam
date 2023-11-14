package com.csnobugteam.java.homework.day26;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串数组 words 和一个字符串 chars.
 * 如果一个字符串能被 chars 里面的字符组成，那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
 * 求：words 里面所有好的字符串的字符总个数。
 * 比如： words = ["cat", "bt", "hat", "tree"] chars = "atach"
 * 好的字符串有 "cat", "hat", 3 + 3 = 6. 输出：6
 *
 * @author aixu
 * @since 2023/11/14
 */
public class Test02 {
    public int findGoodStringNums(String[] words, String chars) {
        int res = 0;

        Map<Character, Integer> goodStrMap = new HashMap<>();
        // 先把，chars存入map
        char[] charArray = chars.toCharArray();
        for (char c : charArray) {
            goodStrMap.put(c, 0);
        }
        boolean flag = true;
        for (String word : words) {
            char[] wordCharArray = word.toCharArray();
            for (char c : wordCharArray) {
                if (goodStrMap.getOrDefault(c,-1) == -1){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (char c : wordCharArray) {
                    int count = goodStrMap.get(c);
                    goodStrMap.put(c, ++count);
                }
            }
            flag = true;
        }

        Set<Map.Entry<Character, Integer>> entries = goodStrMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            res += entry.getValue();
        }

        return res;
    }
}
