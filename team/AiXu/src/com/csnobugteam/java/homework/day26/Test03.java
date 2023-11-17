package com.csnobugteam.java.homework.day26;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数, 返回它们的索引。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 比如：nums = [2, 7, 11, 15], target = 9.
 * 因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0, 1].
 *
 * @author aixu
 * @since 2023/11/14
 */
public class Test03 {

    public int[] returnNumsArray(int[] nums, int target) {
        int[] res = {0};
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) return new int[]{i, j};
            }
        }
        return res;
    }

}
