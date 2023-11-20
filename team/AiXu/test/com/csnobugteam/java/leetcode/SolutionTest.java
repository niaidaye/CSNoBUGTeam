package com.csnobugteam.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rearrangeCharacters() {
        Solution solution = new Solution();

        // 测试1：基本情况
        assertEquals(2, solution.rearrangeCharacters("abcabc", "abc"));

        // 测试2：空字符串
        assertEquals(0, solution.rearrangeCharacters("", "abc"));

        // 测试3：字符串包含目标字符但无法完全排列成目标字符串
        assertEquals(2 , solution.rearrangeCharacters("ilovecodingonleetcode", "code"));

    }
}