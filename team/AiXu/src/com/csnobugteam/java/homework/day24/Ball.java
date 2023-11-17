package com.csnobugteam.java.homework.day24;

/**
 * 球
 */
public class Ball {
    private final String color;
    private final int value;

    public Ball(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }
}
