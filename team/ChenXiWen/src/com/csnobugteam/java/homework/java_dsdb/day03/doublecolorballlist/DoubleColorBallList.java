package com.csnobugteam.java.homework.java_dsdb.day03.doublecolorballlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 请存储到List中一注随机生成双色球号码。 双色球规则：
 * 1.双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 2.红色球号码从1—33中选择(红色号码不重复)；蓝色球号码从1—16中选择；
 * @auther cxw
 * @since 2023/11/11
 */
public class DoubleColorBallList {

    @Test
    public void createDoubleBallNum() {
        List<Ball> list = new ArrayList<>();
        // 循环生成红色球，如果不重复，则添加进list
        while (true) {
            RedBall redBall = new RedBall();
            if (!list.contains(redBall)) {
                list.add(redBall);
            }
            if (list.size() == 6) {
                break;
            }
        }
        // 添加最后一个蓝色球
        list.add(new BlueBall());
        // 打印生成的双色球号码
        System.out.printf("生成的随机双色球号码为：");
        for (Ball ball : list) {
            System.out.printf(ball.num + " ");
        }
    }
}

// 双色球父类
class Ball {
    int num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}

// 红色球
class RedBall extends Ball{

    public RedBall() {
        num = (int)(Math.random()*33) + 1;
    }


}

// 蓝色球
class BlueBall extends Ball{

    public BlueBall() {
        num = (int)(Math.random()*16) + 1;
    }
}
