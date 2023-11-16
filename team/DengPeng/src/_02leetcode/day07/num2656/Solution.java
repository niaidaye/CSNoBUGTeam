package _02leetcode.day07.num2656;


/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
 * 从 nums 中选择一个元素 m 。
 * 将选中的元素 m 从数组中删除。
 * 将新元素 m + 1 添加到数组中。
 * 你的得分增加 m 。
 * 请你返回执行以上操作恰好 k 次后的最大得分。
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/15 20:52
 */
public class Solution {
    public int maximizeSum(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return -1;
        }

        int sum = 0;
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
            }
        }
        // 求和公式
        sum = ((maxValue * 2 + k - 1) * k) / 2;
        return sum;
    }
}
