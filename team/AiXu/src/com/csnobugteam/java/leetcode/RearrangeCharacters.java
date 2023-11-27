package com.csnobugteam.java.leetcode;

/**
 * leetcode题目
 *
 * @author aixu
 * @since 2023/11/17
 */
public class RearrangeCharacters {

    /**
     * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
     * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
     *
     * @param s      查找副本字符串
     * @param target 目标字符串
     * @return 最大副本
     */
    public int rearrangeCharacters(String s, String target) {
        if (s == null || target == null || s.isEmpty() || target.isEmpty()) {
            return 0; // 处理空字符串的情况
        }

        int[] targetCharCount = new int[26];

        // 计算目标字符串中每个字符的出现次数
        for (char targetChar : target.toCharArray()) {
            targetCharCount[targetChar - 'a']++;
        }

        int maxCopies = Integer.MAX_VALUE;

        // 遍历目标字符串中的字符，计算每个字符在源字符串中的最大副本数
        for (char targetChar : target.toCharArray()) {
            int countInSource = 0;

            // 计算源字符串中当前字符的出现次数
            for (char sourceChar : s.toCharArray()) {
                if (sourceChar == targetChar) {
                    countInSource++;
                }
            }

            // 计算当前字符的最大副本数，并更新最小值
            int copies = countInSource / targetCharCount[targetChar - 'a'];
            maxCopies = Math.min(maxCopies, copies);
        }

        return maxCopies;
    }
}