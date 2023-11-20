package com.csnobugteam.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RearrangeCharactersTest {

    @Test
    public void rearrangeCharacters() {
        RearrangeCharacters rearrangeCharacters = new RearrangeCharacters();

        // 测试1：基本情况
        assertEquals(2, rearrangeCharacters.rearrangeCharacters("abcabc", "abc"));

        // 测试2：空字符串
        assertEquals(0, rearrangeCharacters.rearrangeCharacters("", "abc"));

        // 测试3：字符串包含目标字符但无法完全排列成目标字符串
        assertEquals(2 , rearrangeCharacters.rearrangeCharacters("ilovecodingonleetcode", "code"));

    }
}