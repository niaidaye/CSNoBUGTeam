package _02leetcode.day13.num746;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/23 14:15
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        int n = cost.length - 1;
        memo[0] = cost[0];
        memo[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            memo[i] = Math.min(memo[i - 1], memo[i - 2]) + cost[i];
        }

        return Math.min(memo[n], memo[n - 1]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        // 这个是错误的解法
        int sum = 0;
        int i = cost.length;
        while(i > 1){
            if(cost[i-1] > cost[i-2]){
                sum += cost[i-2];
                i -= 2;
            }else{
                sum += cost[i-1];
                i--;
            }
        }
        return sum;
    }
}
