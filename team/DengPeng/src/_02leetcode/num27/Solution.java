package _02leetcode.num27;


/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        // 类似双指针,如果没有发现与val重复的元素，则继续遍历
        // 如果有重复的元素，那么就移除
        int slow = -1, fast = 0;
        // 快指针先遍历寻找，从0下标开始找
        while (fast < nums.length) {
            // 如果没有重复的元素，继续遍历，有重复的元素则慢指针则不前进
            if (nums[fast] != val) {
                slow++;
                nums[slow] = nums[fast];
            }
            // 快指针继续遍历
            fast++;
        }

        // 返回已过滤好的数组中需要的元素个数
        return slow + 1;
    }
}
