package _02leetcode.day10.num53;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/20 9:11
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return -1;
        } else if (nums.length == 1){
            return nums[0];
        }

        int slow = 0,fast = 0;

        // 设置一个数组记录以nums[i]为结尾的最大连续子数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        // dp数组已经成功记录数据
        int res = dp[0];
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }


}
