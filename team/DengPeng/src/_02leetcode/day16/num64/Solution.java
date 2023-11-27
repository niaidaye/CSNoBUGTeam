package _02leetcode.day16.num64;

/**
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/27 23:23
 */
public class Solution {
    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][200];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = grid[i][j];
                        continue;
                    }
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        int m = grid.length;
        int n = grid[m - 1].length;

        return dp[m - 1][n - 1];
    }
}
