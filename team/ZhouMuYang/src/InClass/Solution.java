package InClass;
import org.junit.Test;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * @author stephen
 * @date 2023/11/24 9:29
 */
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length()-1; i >0 ; i--) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }
        System.out.println(map);
        int sum=0;
        Set<Entry<Character, Integer>> entrySet = map.entrySet();
        for (Entry<Character, Integer> entry : entrySet) {
            if (entry.getKey().equals("V")) {
                sum+=entry.getValue();
            }
        }
        return sum;
    }

    @Test
    public void testDemo() {
        String s = "IIIVVV";
        System.out.println(romanToInt(s));
    }
}

