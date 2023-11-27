package _02leetcode.day13.num70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/23 9:20
 */

// 备忘录解法解斐波那契秒了
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2)return n;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3;i <= n;i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}
