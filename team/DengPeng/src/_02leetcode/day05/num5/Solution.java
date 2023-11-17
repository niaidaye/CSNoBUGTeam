package _02leetcode.day05.num5;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/13 22:54
 */
/*
给你一个字符串 s，找到 s 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        // 双指针判断反转字符串
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以s[i]为中心的最长回文字符串
            String s1 = palindrome(s, i, i);
            // 以s[i]和s[i+1]为中心的最长回文字符串
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int left, int right) {
        // 防止索引越界
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // left往左继续找，right往右继续找
            left--;
            right++;
        }
        // 返回一个回文子串
        return s.substring(left + 1, right);
    }
}
