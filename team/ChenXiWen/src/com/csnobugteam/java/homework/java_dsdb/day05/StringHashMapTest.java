package com.csnobugteam.java.homework.java_dsdb.day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串数组 words 和一个字符串 chars. 如果一个字符串能被 chars 里面的字符组成，那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
 * 求：words 里面所有好的字符串的字符总个数。
 * 比如：
 * words = ["cat", "bt", "hat", "tree"]
 * chars = "atach"
 * 好的字符串有 "cat", "hat", 3 + 3 = 6.
 * 输出：6
 * @auther cxw
 * @since 2023/11/14
 */
public class StringHashMapTest {
    @Test
    public void countCharNum() {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            Integer count = map.getOrDefault(chars.charAt(i), 0);
            map.put(chars.charAt(i), count + 1);
        }
        // 获取好的字符串的字符总个数
        int charCount = getCharCount(words, map);
        System.out.println("好的字符串的字符总个数为：" + charCount);
    }

    public int getCharCount(String[] words, Map<Character, Integer> map) {
        // 记录好的字符串的字符总个数
        int charCount = 0;
        // 遍历数组得出charCount
        for (String word : words) {
            // 将map复制一份
            Map<Character, Integer> hashMap = new HashMap<>(map);
            // flag用于判断是否为好的字符串
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                Integer count = hashMap.getOrDefault(word.charAt(i), 0);
                // 如果count为0说明字符串chars中不存在该字符或该字符已用完
                if (count == 0) {
                    flag = false;
                    break;
                }
                hashMap.put(word.charAt(i), count - 1);
            }
            if (flag) {
                charCount += word.length();
            }
        }
        return charCount;
    }

    public static  int countCharacters(String[] words, String chars) {

        // 把chars(源字符串)字符串遍历, 并存储出现的字符和其出现的次数
        Map<Character, Integer> map = createMap(chars);

        int sum = 0;

        // 遍历:判断能否被chars组成
        for(String s : words) {

            // 把当前遍历字符s,  也存储出现的字符和其出现的次数
            Map<Character, Integer> m = createMap(s);

            // canGenerate(m, map): 判断m 是否能够由map组成
            if (canGenerate(m, map)) {
                // 能够由map组成则记录该次字符数
                sum += s.length();
            }
        }
        return sum;
    }

    // 计算 m字符 出现的对应字符次数,  是否在map中都能包含
    private static boolean canGenerate(Map<Character, Integer> m, Map<Character, Integer> map) {

        Set<Map.Entry<Character, Integer>> entries = m.entrySet();
        // 遍历 m 字符
        for(Map.Entry<Character, Integer> entry : entries) {

            // 判断m字符中的每个字符是否都在源字符中存在, 并且次数满足够用
            Character c = entry.getKey();
            int cnt = entry.getValue();
            if (!map.containsKey(c) || map.get(c) < cnt){
                return false;
            }
        }
        return true;
    }

    // 把字符串遍历, 并存储出现的字符和其出现的次数
    private static Map<Character, Integer> createMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
