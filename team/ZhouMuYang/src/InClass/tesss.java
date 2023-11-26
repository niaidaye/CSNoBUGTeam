package InClass;

import com.sun.scenario.effect.Merge;
import org.junit.Test;

import java.util.*;

/**
 * @author stephen
 * @date 2023/11/22 20:20
 */
public class tesss {
    @Test
    public void test() {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(ints));
    }

    @Test
    public void teee() {
        char a = '\u0000';
        System.out.println(a);
    }

    public int removeDuplicates(int[] nums) {
        int left=0;
        int[] intsCopy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < intsCopy.length; i++) {
            boolean flag=true;
            for (int j = 0; j < left; j++) {
                if (nums[j] == intsCopy[i]) {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                nums[left++] = intsCopy[i];
            }
        }
        return left;

    }
}


