package com.csnobugteam.java.homework.day25;

import org.junit.Test;

public class ArrayListHomoWorkTest {

    ArrayListHomoWork arrayListHomoWork = new ArrayListHomoWork();
    @Test
    public void overKillString() {
        String temo = "abcqweracb";

        System.out.println("执行前："+temo);

        System.out.println(arrayListHomoWork.overKillString(temo));
    }
}