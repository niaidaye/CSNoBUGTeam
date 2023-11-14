package com.csnobugteam.java.leetcode;

/**
 * 二分搜索
 *
 * @author aixu
 * @since 2023/11/12
 */
public class BinarySearch {
    public int binarySearch(int[] nums,int target){
        // 确立边界
        int left = 0, right = nums.length - 1;
        // 确定结束条件
        while(left <= right) {
            // 进行中心点赋值
            int min = left + (right - left) / 2;
            // 进行搜索
            if(nums[min] == target) return min;
            else if (nums[min] > target) {
                // 收缩右边界
                right = min - 1;

            } else if (nums[min] < target) {
                // 收缩左边界
                left = min + 1;

            }
        }

        return -1;
    }
}
