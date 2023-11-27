package _02leetcode.day15.num62;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/25 9:28
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i][j - 1] + arr[i-1][j];
            }
        }

        return arr[m-1][n-1];
    }

}
