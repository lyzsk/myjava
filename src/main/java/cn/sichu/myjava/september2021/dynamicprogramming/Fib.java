package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * <strong>509. 斐波那契数</strong> @see<a href = "https://leetcode-cn.com/problems/fibonacci-number/">509. 斐波那契数</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * 
 * <pre>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * </pre>
 * <p>
 * 给你 n ，请计算 F(n) 。
 * 
 * @author sichu
 * @date 2021/09/04
 */
public class Fib {
    public int fib(int n) {
        // int a = 0;
        // int b = 1;
        // while (n-- > 0) {
        // int c = a + b;
        // a = b;
        // b = c;
        // }
        // return a;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[30];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
