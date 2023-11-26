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
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
//counts.getOrDefault()
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    @Test
    public void tet() {
      
    }

    @Test
    public void tt() {
    }
}

