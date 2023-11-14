package _02leetcode.day06.num303;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/14 21:55
 */
public class NumArray {

    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        for (int i = 0; i < preSum.length; i++) {
            if (i == 0) {
                preSum[i] = 0 + nums[0];
            } else {
                preSum[i] = preSum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right] - preSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */