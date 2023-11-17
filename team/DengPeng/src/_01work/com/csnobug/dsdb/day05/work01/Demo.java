package _01work.com.csnobug.dsdb.day05.work01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t, 它们只包含小写字母。字符串t是由s中的字母随机打乱之后，
 * 在随机的一个位置添加一个字母生成的。请找出那个添加的字母。
 * 比如：
 * s = "abcd"
 * t = "baedc"
 * 输出：e
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/14 20:50
 */
public class Demo {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "baedc";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            if (count == 0) {
                System.out.println(c);
            }
        }
    }
}
