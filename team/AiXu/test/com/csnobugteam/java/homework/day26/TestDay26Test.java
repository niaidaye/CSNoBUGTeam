package com.csnobugteam.java.homework.day26;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试第26天作业
 */
public class TestDay26Test {

    /**
     * 测试第一题
     */
    @Test
    public void testFindAddedLetter() {
        Test01 test01 = new Test01();

        String result1 = test01.findAddedLetter("abc", "abcd");
        assertEquals("d", result1);

        String result2 = test01.findAddedLetter("abc", "zabc");
        assertEquals("z", result2);

        String result3 = test01.findAddedLetter("abc", "xyzabc");
        assertEquals("xyz", result3);

        String result4 = test01.findAddedLetter("abc", "abc");
        assertEquals("", result4);

        String result5 = test01.findAddedLetter("", "");
        assertEquals("", result5);
    }

    /**
     * 测试第二题
     */
    @Test
    public void testFindGoodStringNums() {
        Test02 test02 = new Test02();

        String[] words0 = {"cat", "bt", "hat", "tree"};
        String chars0 = "atach";
        int result0 = test02.findGoodStringNums(words0, chars0);
        assertEquals(6, result0);

        String[] words1 = {"abc"};
        String chars1 = "abc";
        int result1 = test02.findGoodStringNums(words1, chars1);
        assertEquals(3, result1);

        String[] words2 = {"abcd"};
        String chars2 = "abc";
        int result2 = test02.findGoodStringNums(words2, chars2);
        assertEquals(0, result2);

        String[] words3 = {"abc", "def", "gh"};
        String chars3 = "abcdefgh";
        int result3 = test02.findGoodStringNums(words3, chars3);
        assertEquals(8, result3);

        String[] words4 = {"abc", "def", "gh"};
        String chars4 = "ijklmnop";
        int result4 = test02.findGoodStringNums(words4, chars4);
        assertEquals(0, result4);

        String[] words5 = {};
        String chars5 = "";
        int result5 = test02.findGoodStringNums(words5, chars5);
        assertEquals(0, result5);
    }

    @Test
    public void testReturnNumsArray() {
        Test03 test03 = new Test03();  // 替换成你的类名

        // 测试用例1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 1};
        assertArrayEquals(expected1, test03.returnNumsArray(nums1, target1));

        // 测试用例2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] expected2 = {1, 2};
        assertArrayEquals(expected2, test03.returnNumsArray(nums2, target2));

        // 测试用例3（如果有其他测试用例，请继续添加）
        int[] nums3 = {0, 4, 3, 0};
        int target3 = 0;
        int[] expected3 = {0, 3};
        assertArrayEquals(expected3, test03.returnNumsArray(nums3, target3));
    }
}