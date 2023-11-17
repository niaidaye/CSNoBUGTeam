package _01work.com.csnobug.dsdb.day05.work03;

import java.util.Arrays;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数, 返回它们的索引。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 比如：nums = [2, 7, 11, 15], target = 9.
 * 因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0, 1].
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/14 21:22
 */
public class Demo {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        // 双指针指向两端
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                System.out.println(Arrays.toString(new int[]{low, high}));
                break;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

    }
}
