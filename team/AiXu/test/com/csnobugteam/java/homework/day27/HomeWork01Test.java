package com.csnobugteam.java.homework.day27;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class HomeWork01Test {

    @Test
    public void getNumsOfAppears() {
        HomeWork01 homeWork01 = new HomeWork01();

        // Test case 1: Empty string
        Map<Character, Integer> result1 = homeWork01.getNumsOfAppears("");
        assertEquals(0, result1.size());

        // Test case 2: String with repeated characters
        Map<Character, Integer> result2 = homeWork01.getNumsOfAppears("aababcabcdabcde");
        assertEquals(5, result2.size());

        assertEquals(5, result2.get('a').intValue());
        assertEquals(4, result2.get('b').intValue());
        assertEquals(3, result2.get('c').intValue());
        assertEquals(2, result2.get('d').intValue());
        assertEquals(1, result2.get('e').intValue());
    }
}