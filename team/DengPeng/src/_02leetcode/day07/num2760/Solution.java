package _02leetcode.day07.num2760;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/16 21:35
 */
/*
给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。

请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：

nums[l] % 2 == 0
对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
以整数形式返回满足题目要求的最长子数组的长度。

注意：子数组 是数组中的一个连续非空元素序列。
 */
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        // 用于计算满足要求的这个子数组的长度
        int ans = 0;
        int slow = 0, fast, cur;
        while (slow < nums.length) {
            if (nums[slow] % 2 != 0 || nums[slow] > threshold) {
                slow++;
                continue;
            }
            fast = slow + 1;
            cur = nums[slow] % 2;
            while (fast < nums.length) {
                if (nums[fast] > threshold || nums[fast] % 2 == cur) {
                    break;
                }
                cur = nums[fast++] % 2;
            }
            ans = Math.max(ans, fast - slow);
            slow = fast;
        }

        return ans;
    }

    public int longestAlternatingSubarray1(int[] nums, int threshold) {
        int ans = 0;
        int slow = 0, fast, cur;

        while (slow < nums.length) {
            if (nums[slow] % 2 != 0 || nums[slow] > threshold) {
                slow++;
                continue;
            }

            fast = slow + 1;
            cur = nums[slow] % 2;

            while (fast < nums.length) {
                if (nums[fast] > threshold || nums[fast] % 2 == cur) {
                    break;
                }
                cur = nums[fast] % 2;
                fast++;
            }

            ans = Math.max(ans, fast - slow);
            slow = fast;
        }

        return ans;
    }
}
