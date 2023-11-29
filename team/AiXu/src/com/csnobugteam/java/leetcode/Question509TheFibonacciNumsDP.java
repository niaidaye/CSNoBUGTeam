package com.csnobugteam.java.leetcode;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        // 暴力算法
//        if( n == 1 || n == 2) return 1;
//        return fib(n -1) + fib(n - 2);
        // 带备忘录的递归
        int memo[] = new int[n + 1];
        return helpr(memo, n);
    }

    public int helpr(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) return n;
        // 已经计算过，不用计算
        if(memo[n] != 0) return memo[n];
        // 递归体
        return helpr(memo, n - 1) + helpr(memo, n - 2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
