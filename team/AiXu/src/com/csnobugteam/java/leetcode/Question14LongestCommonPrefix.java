package com.csnobugteam.java.leetcode;

public class Question14LongestCommonPrefix {
    /*
     * @lc app=leetcode.cn id=14 lang=java
     *
     * [14] 最长公共前缀
     *
     * https://leetcode.cn/problems/longest-common-prefix/description/
     *
     * algorithms
     * Easy (43.59%)
     * Likes: 3001
     * Dislikes: 0
     * Total Accepted: 1.2M
     * Total Submissions: 2.8M
     * Testcase Example: '["flower","flow","flight"]'
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 
     * 如果不存在公共前缀，返回空字符串 ""。
     * 
     * 
     * 
     * 示例 1：
     * 
     * 
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 
     * 
     * 示例 2：
     * 
     * 
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * 
     * 
     * 
     * 提示：
     * 
     * 
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * 
     * 
     */

    // @lc code=start
    public String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                String thisStrs = strs[j], prewStrs = strs[j - 1];
                if (i >= thisStrs.length()
                        || i >= prewStrs.length()
                        || thisStrs.charAt(i) != prewStrs.charAt(i)) {
                    return strs[j].substring(0, i);
                }
            }

        }
        return strs[0];
    }
    // @lc code=end

}
