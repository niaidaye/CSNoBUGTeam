package com.csnobugteam.java.leetcode;

/**
 * 给你三个字符串 s1、s2 和 s3。 你可以根据需要对这三个字符串执行以下操作 任意次数 。
 * 在每次操作中，你可以选择其中一个长度至少为 2 的字符串 并删除其 最右位置上 的字符。
 * 如果存在某种方法能够使这三个字符串相等，请返回使它们相等所需的 最小 操作次数；否则，返回 -1。
 * 示例 1：
 * 输入：s1 = "abc"，s2 = "abb"，s3 = "ab"
 * 输出：2
 * 解释：对 s1 和 s2 进行一次操作后，可以得到三个相等的字符串。
 * 可以证明，不可能用少于两次操作使它们相等。
 * 示例 2：
 * 输入：s1 = "dac"，s2 = "bac"，s3 = "cac"
 * 输出：-1
 * 解释：因为 s1 和 s2 的最左位置上的字母不相等，所以无论进行多少次操作，它们都不可能相等。因此答案是 -1 。
 * 提示：
 * 1 <= s1.length, s2.length, s3.length <= 100
 * s1、s2 和 s3 仅由小写英文字母组成。
 * @author aixu
 * @since 2023/11/20
 */
public class MinimumOperations {
    public int minimumOperations(String s1, String s2, String s3) {
        // 获取字符串最后一个下标
        int i = s1.length() - 1, j = s2.length() - 1, k = s3.length() - 1;
        int res = 0;
        while(i >= 0 && j >= 0 && k >= 0){
            if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
                i--;
                j--;
                k--;
            }else{
                boolean hasNext = (i >= 1 && s1.charAt(i - 1) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) ||
                        (j >= 1 && s1.charAt(i) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k)) ||
                        (k >= 1 && s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k - 1));
                // 用来判断是否存在可行的删除操作
                // 如果不存在可行的删除操作，即使三字符串中的某一个已经处理完，其他的指针位置也无法使得剩余的两字符串变得相同，因此返回-1
                if(!hasNext) return -1;
                if( s1.charAt(i) != s2.charAt(j) &&
                    s1.charAt(i) != s3.charAt(k))
                    i--;
                else if( s1.charAt(i) != s2.charAt(j) &&
                         s2.charAt(j) != s3.charAt(k))
                    j--;
                else k--;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
