package com.csnobugteam.java.homework.day26;

import java.util.HashMap;
import java.util.Map;

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

        // 创建字符计数的Map
        Map<Character, Integer> goodStrMap = createMap(chars);

        for (String word : words) {
            // 创建当前单词的字符计数的Map
            Map<Character, Integer> wordMap = createMap(word);

            // 判断当前单词是否为"好"的字符串
            if (judgeGoodStr(goodStrMap, wordMap)) {
                res += word.length();
            }
        }

        return res;
    }

    private Map<Character, Integer> createMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private boolean judgeGoodStr(Map<Character, Integer> chars, Map<Character, Integer> judgeMap) {
        // 检查是否存在字符数量不足的情况
        for (Map.Entry<Character, Integer> entry : judgeMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (!chars.containsKey(c) || chars.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}
