package _02leetcode.day14.num2824;

import java.util.Collections;
import java.util.List;

/**
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，
 * 请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 *
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/24 9:10
 */
public class Solution {

    /*
    * Collections.sort(nums);
        int n = nums.size(), ans = 0;
        for (int l = 0, r = n - 1; l < r; l++) {
            while (r >= 0 && nums.get(l) + nums.get(r) >= target) r--;
            if (l < r) ans += r - l;
        }
        return ans;
    * */
    public int countPairs(List<Integer> nums, int target) {
        // 对输入的整数列表进行排序
        Collections.sort(nums);

        // 获取列表的大小
        int n = nums.size();

        // 初始化答案变量，用于存储满足条件的数对数量
        int ans = 0;

        // 使用双指针，分别从列表的起始和末尾开始遍历
        for (int l = 0, r = n - 1; l < r; l++) {
            // 在右指针大于等于0的情况下，循环执行以下步骤
            while (r >= 0 && nums.get(l) + nums.get(r) >= target) {
                // 如果当前左指针和右指针指向的元素之和大于等于目标值，
                // 将右指针向左移动，减小和，以便找到更小的和满足条件
                r--;
            }

            // 如果左指针小于右指针，说明找到了满足条件的数对
            if (l < r) {
                // 统计满足条件的数对数量，并加到答案中
                ans += (r - l);
            }
        }

        return ans;
    }


    public int countPairs1(List<Integer> nums, int target) {
        // 排序
        Collections.sort(nums);
        // 再双指针
        int low, high = nums.size() - 1;
        // 定义个数
        int res = 0;

        for (int i = 0; i < nums.size() - 1 && i != high; i++) {
            low = i;
            while (low < high) {
                if (nums.get(low) + nums.get(high) >= target) high--;
                else res++;
            }
        }

        return res;
    }
}
