package src.homework.day6;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/15
 */


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
"aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
 */
public class Demo1 {
    public static void main(String[] args) {

        // 定义字符串数组
        String s = "aababcabcdabcde";

        // 定义一个求字母出现次数的方法
        NumbeOfOccurrences(s);

    }

    private static void NumbeOfOccurrences(String s) {

        // 运用哈希表来存储每个字母的出现次数
        HashMap<Character, Integer> counts = new HashMap<>();


        // 遍历输入字符串，更新字母出现次数
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);

        }

        // 将HashMap 字母排序
        Map<Character, Integer> sortedCounts = new TreeMap<>(counts);


        // 打印结果
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue() + "次");

        }
    }

}




