package _01work.com.csnobug.dsdb.day03.work03;

import java.util.ArrayList;
import java.util.List;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/11 16:42
 * @Version 1.0
 */
/*
请存储到List中一注随机生成双色球号码。
双色球规则： 双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
红色球号码从1—33中选择(红色号码不重复)；蓝色球号码从1—16中选择；
 */
public class Demo {
    public static void main(String[] args) {
        List<Integer> twoColorBall = new ArrayList<>();
        List<Integer> redBallNum = getRedBallNumByRandom(5);
        List<Integer> blueBallNum = getBlueBallNumByRandom(1);

        twoColorBall.addAll(redBallNum);
        twoColorBall.addAll(blueBallNum);
        System.out.println("------------two Color number------------");
        System.out.println(twoColorBall);
    }

    private static List<Integer> getBlueBallNumByRandom(int num) {
        List<Integer> getBlueBallNum = new ArrayList<>();
        getBlueBallNum.add((int) (Math.random() * 16) + 1);

        System.out.println("------------the blue number------------");
        System.out.println(getBlueBallNum);
        return getBlueBallNum;
    }

    private static List<Integer> getRedBallNumByRandom(int num) {
        List<Integer> getRedBallNum = new ArrayList<>();

        // 2层for设置arr数组为不重复的num个元素，范围在[1，33]
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;

            do {
                // 先给arr[i]赋值
                arr[i] = (int) (Math.random() * 33) + 1;
                // 判断在i之前是否有元素和arr[i]重复，如果有，则重新赋值arr[i]
                for (int j = 0; j < i; j++) {
                    if (arr[j] == arr[i]) {
                        arr[i] = (int) (Math.random() * 33) + 1;
                        flag = true;
                    }
                }
                // 重复读取判断
            }while (flag);
        }

        // 读入List
        for (int i : arr) {
            getRedBallNum.add(i);
        }

        System.out.println("------------the red number------------");
        System.out.println(getRedBallNum);
        return getRedBallNum;
    }
}
