package _02leetcode.day10.num983;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有 三种不同的销售方式 ：
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 *
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/20 23:06
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int[] ticketSell = {1, 7, 30};

        int res = getMinCost(days, costs, ticketSell);

        return res;
    }

    private int getMinCost(int[] days, int[] costs, int[] ticketSell) {
        if(days.length == 0) return 0;

        int[] dp = new int[days.length + 1];

        for (int i = 0; i < days.length; i++) {

            for (int ticket : ticketSell) {

            }

        }


        return 0;
    }
}
