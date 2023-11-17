package com.csnobugteam.java.homework.day28;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReturnNumsHomeWorkTest {

    @Test
    public void returnNumSquares() {
        ReturnNumsHomeWork returnNumsHomeWork = new ReturnNumsHomeWork();
        // Test case 1
        List<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result1 = returnNumsHomeWork.ReturnNumSquares(input1);
        List<Integer> expected1 = Arrays.asList(1, 4, 9, 16, 25);
        assertEquals(expected1, result1);

        // Test case 2 (additional test case)
        List<Integer> input2 = Arrays.asList(0, -1, 2, -3, 4);
        List<Integer> result2 = returnNumsHomeWork.ReturnNumSquares(input2);
        List<Integer> expected2 = Arrays.asList(0, 1, 4, 9, 16);
        assertEquals(expected2, result2);
    }
}