package com.csnobugteam.java.homework.java_dsdb.day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t, 它们只包含小写字母。字符串t是由s中的字母随机打乱之后，在随机的一个位置添加一个字母生成的。请找出那个添加的字母。
 * 比如：
 * s = "abcd"
 * t = "baedc"
 * 输出：e
 * @auther cxw
 * @since 2023/11/14
 */
public class FindChar {
    @Test
    public void findCharTest() {
        String str1 = "abcd";
        String str2 = "baedc";
        // 创建一个HashMap，key为字符，value为字符串中字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        // 将原字符串中的字符和字符出现次数放入map中
        for (int i = 0; i < str1.length(); i++) {
            Integer count = map.getOrDefault(str1.charAt(i), 0);
            map.put(str1.charAt(i), count + 1);
        }
        // 新字符串中的字符每出现一次，则将map中对应key的value减1
        for (int i = 0; i < str2.length(); i++) {
            Character ch = str2.charAt(i);
            Integer count = map.getOrDefault(ch, 0);
            // 如果在map中未找到该字符串，则说明这就是被添加的字母
            if (count == 0) {
                System.out.println("已找到该字母：" + ch);
                return;
            }
            map.put(ch, count - 1);
        }
    }
}
