package InClass;

import org.junit.Test;
/**
 * @author stephen
 * @date 2023/11/24 9:29
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author stephen
 * @date 2023/11/23 23:45
 */
public class Solution {
    public int maxProfit(int[] prices) {
        boolean flag=true;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                flag=false;
            }
        }
        if (flag) {
            return 0;
        }

        int max = maxArray(prices);
        int min = minArray(prices);
        return max-min;
    }

    public int maxArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public int minArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if (min >arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}

