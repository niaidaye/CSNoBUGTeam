package src.homework.day5;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/14
 */


import java.util.HashMap;
import java.util.Map;

/*


给定一个字符串数组 words 和一个字符串 chars. 如果一个字符串能被 chars 里面的字符组成，
那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
求：words 里面所有好的字符串的字符总个数。
比如：
words = ["cat", "bt", "hat", "tree"]
chars = "atach"
好的字符串有 "cat", "hat", 3 + 3 = 6.
输出：6
 */
public class Demo2 {
    public static void main(String[] args) {
        // 定义一个字符串数组 words
        String[] words = {"cat", "bt", "hat", "tree"};
        // 定义一个字符串 chars
        String chars = "atach";

        // 定义一个找到 "好" 的的字符串总个数方法
        int result = countCharacters(words, chars);

        // 打印"好" 的的字符串总个数
        System.out.println("好 的的字符串总个数:" + result);

    }

    private static int countCharacters(String[] words, String chars) {

        // 统计 chars 中每个字符出现的次数
        int totalCharacters = 0;

        // 哈希表来统计字符串出现的次数，确保字符不会重复
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 遍历words数组中每个字符串
        for (String word : words) {

            // 复制 charcount 以便在检查当前字符串时不修改原始计数
            HashMap<Character, Integer> tempCount = new HashMap<>(charCount);

            // 检查当前字符串是否由 chars 中字符串组成
            boolean goodString = true;

            for (char c : word.toCharArray()) {
                if (!tempCount.containsKey(c) || tempCount.get(c) == 0) {
                    goodString = false;
                    break;
                }
                tempCount.put(c, tempCount.get(c) - 1);
            }

            // 如果是好的字符串，累加字符个数
            if (goodString) {
                totalCharacters += word.length();
            }
        }

        return totalCharacters;
    }
}

