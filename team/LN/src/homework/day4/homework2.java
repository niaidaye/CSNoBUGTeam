package src.homework.day4;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/11
 */


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
请存储到List中一注随机生成双色球号码。 双色球规则： 双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。 红色球号码从1—33中选择(红色号码不重复)；蓝色球号码从1—16中选择；
 */
public class homework2 {
    public static void main(String[] args) {
        // 存放红球
        Set<Integer> redBallRandom = new HashSet<>();
        // 存放蓝色球
        Set<Integer> blueBallRandom = new HashSet<>();

        // 将随机产生的红球号码放入集合中
        while (redBallRandom.size() < 6) {
            int i = (int) ((Math.random() * 33 + 1));
            redBallRandom.add(i);
        }
        blueBallRandom.add((int) ((Math.random() * 16) + 1));

        System.out.println("红球号码为：");
        Iterator<Integer> iterator = redBallRandom.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");

        }
        System.out.println();
        System.out.println("蓝球号码为：");
        System.out.println(blueBallRandom.iterator().next());

    }
}

