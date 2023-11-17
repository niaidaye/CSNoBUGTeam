package _01work.com.csnobug.dsdb.day05.work02;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串数组 words 和一个字符串 chars. 如果一个字符串能被 chars 里面的字符组成，那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
 * 求：words 里面所有好的字符串的字符总个数。
 * 比如：
 * words = ["cat", "bt", "hat", "tree"]
 * chars = "atach"
 * 好的字符串有 "cat", "hat", 3 + 3 = 6.
 * 输出：6
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/14 20:59
 */
public class Demo {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";

        Map<Character, Integer> map = new HashMap<>();

        int goodCharNum = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < chars.length(); j++) {
                char c = chars.charAt(j);
                Integer count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }

            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                Integer count = map.get(c);
                if (count == null || count <= 0) {
                    goodCharNum -= 3;
                    break;
                }
                map.put(c, count - 1);
            }
            goodCharNum += 3;
            map.clear();
        }
        System.out.println(goodCharNum);
    }
}
