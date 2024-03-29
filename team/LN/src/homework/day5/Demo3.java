package src.homework.day5;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/14
 */


import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数, 返回它们的索引。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

比如：nums = [2, 7, 11, 15], target = 9.
因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0, 1].
 */
public class Demo3 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        int[] result = s.twoSum(nums, target);

        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {

                Integer index = map.get(target - nums[i]);
                if (index != null) {
                    return new int[]{index, i};
                }
            }
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");

    }
}



