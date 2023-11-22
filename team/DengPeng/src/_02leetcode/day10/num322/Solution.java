package _02leetcode.day10.num322;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/20 22:06
 */
public class Solution {
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sumProblem = coinChange1(coins, amount - coin);
            if (sumProblem == -1) {
                continue;
            }
            res = Math.min(res, sumProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int[] dp = new int[amount + 1];

        // dp数组全部初始化为amount + 1
        Arrays.fill(dp, amount + 1);

        // 如果刚好一个硬币能够遍历完，那么会用到dp[0],所以我们将dp[0]设置为0
        dp[0] = 0;
        // 外层for遍历所有状态取值
        for (int i = 0; i <= amount; i++) {
            // 内层for循环求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解就跳过
                if(i - coin < 0) continue;
                // 状态转移
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // 查看金额amount能不能读出来
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
