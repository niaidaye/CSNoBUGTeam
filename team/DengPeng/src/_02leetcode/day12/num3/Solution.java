package _02leetcode.day12.num3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/22 21:38
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 使用 HashMap 存储字符及其最新出现的索引
        Map<Character, Integer> map = new HashMap<>();
        // 用于记录最长子串的长度
        int res = 0;
        // 用于记录当前子串的起始位置
        int start = 0;

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果字符已经在子串中出现过
            if (map.containsKey(c)) {
                // 更新起始位置为重复字符的下一个位置
                start = Math.max(start, map.get(c) + 1);
            }

            // 将字符及其当前索引放入 HashMap
            map.put(c, i);
            // 更新最长子串的长度
            res = Math.max(res, i - start + 1);
        }

        // 返回最终结果
        return res;
    }


}
