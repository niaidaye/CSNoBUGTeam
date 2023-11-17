package com.csnobugteam.java.homework.java_dsdb.day05;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数, 返回它们的索引。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 比如：nums = [2, 7, 11, 15], target = 9.
 * 因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0, 1].
 * @auther cxw
 * @since 2023/11/14
 */
public class ArrayHashMapTest {
    public int[] findTargetNum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void findTargetNumTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] targetNum = findTargetNum(nums, target);
        System.out.println(Arrays.toString(targetNum));
    }
}
