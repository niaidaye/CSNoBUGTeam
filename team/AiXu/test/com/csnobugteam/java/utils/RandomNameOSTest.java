package com.csnobugteam.java.utils;

import org.junit.Test;

public class RandomNameOSTest {

    @Test
    public void readFileNamesToArrays() {

        RandomNameOS randomNameOS = new RandomNameOS("input.txt","output.txt");
        System.out.println("随机点名："+randomNameOS.randomName());

    }
}