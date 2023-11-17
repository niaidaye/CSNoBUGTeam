package homework.day2.day3.list;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/11 4:16 PM
 * @Description: TODO
 */
/*请存储到List中一注随机生成双色球号码。 双色球规则： 双色球每注投注号码由6个红色球号码和
1个蓝色球号码组成。 红色球号码从1—33中选择(红色号码不重复)；蓝色球号码从1—16中选择*/
public class DoubleColorBall {
    public static void main(String[] args) {
//生成随机数用Random，号码不重复用HashSet存储
        RandomNumberRedBall();
    }

    private static void RandomNumberRedBall() {
        //创建set集合
        Set<Integer> numbers=new HashSet<>();
        //生成随机数
        Random random=new Random();
        while(numbers.size()<7){
            int redBallNum=random.nextInt(33)+1;
            numbers.add(redBallNum);
        }
        int buleBallNum= random.nextInt(16)+1;
        numbers.add(buleBallNum);
        int buleBallNum1=0;
        //注意事项：如果需要增删改查List表中的数据，都需要借助迭代器iterator去执行遍历操作，读取操作，
        //因此要牢记迭代器的常用方法结构 ！！！！
        for (int number:numbers
             ) {
            buleBallNum1=number;

        }
        System.out.println("生成的双色号码是"+numbers+"其中蓝色号码是"+buleBallNum1);
    }
}

