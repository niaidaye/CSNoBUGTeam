package _01work.com.csnobug.dsdb.day06.work02;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * "aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/15 17:11
 */
public class Demo {

    @Test
    public void test1() {
        String str = "aababcabcdabcde";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer count = map.getOrDefault(str.charAt(i), 0);
            map.put(str.charAt(i), count + 1);
        }
        System.out.println(map);
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + ")" + "\t");
        }
    }

}
