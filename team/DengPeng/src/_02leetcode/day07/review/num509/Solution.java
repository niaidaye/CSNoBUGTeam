package _02leetcode.day07.review.num509;

/**
 * 复习leetcode第509的斐波那契，使用备忘录递归数组解题
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/16 23:27
 */
public class Solution {
    public int fib(int N) {
        // 备忘录长度定义为N + 1
        // 只需计算memo[1] ~ memo[N]就可以了
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    public int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
}
