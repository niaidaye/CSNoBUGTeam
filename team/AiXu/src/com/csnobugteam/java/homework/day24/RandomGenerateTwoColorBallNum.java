package com.csnobugteam.java.homework.day24;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 请存储到List中一注随机生成双色球号码。
 * 双色球规则：
 * 双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1—33中选择(红色号码不重复)；蓝色球号码从1—16中选择；
 *
 * @author aixu
 * @since 2023/11/11
 */
public class RandomGenerateTwoColorBallNum {


    public List<Ball> generateTowColorNums() {
        List<Ball> ballList = new ArrayList<>();
        // 6个红色球号码
        for (int i = 0; i < 6; i++) {
            int redBallSize = 33;
            ballList.add(randomGetBall(redBallSize,"red"));
        }
        // 一个蓝球号
        int blueBallSize = 16;
        ballList.add(randomGetBall(blueBallSize,"blue"));
        // 返回
        return ballList;
    }

    /**
     * 生成球号
     * @param size 球号范围
     * @param color 球的颜色
     * @return 在球号范围内的一个球号
     */
    private Ball randomGetBall(int size,String color) {
        // 球号池
        List<Ball> ballNumsPool = new ArrayList<>(size);
        // 按照顺序生成球放入，球池
        for (int i = 0; i < size; i++) {
            Ball ball = new Ball(color, i + 1);
            ballNumsPool.add(i, ball);
        }

        // 随机从球池中拿取一个球出来
        return ballNumsPool.get(new Random().nextInt(size+1));
    }
}

