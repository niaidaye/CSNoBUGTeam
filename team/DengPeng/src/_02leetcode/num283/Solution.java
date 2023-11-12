package _02leetcode.num283;


/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        int index = 0;
        // 先将非0元素提前
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // 再将剩下元素全部赋值为0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}