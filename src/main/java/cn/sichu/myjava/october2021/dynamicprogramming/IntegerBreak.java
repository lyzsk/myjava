package cn.sichu.myjava.october2021.dynamicprogramming;

/**
 * 343. 整数拆分 @see<a href = "https://leetcode-cn.com/problems/integer-break/">343. 整数拆分</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 解法
 * <p>
 * 动态规划。
 * <p>
 * 设 dp[i] 表示正整数 n 能获得的最大乘积，初始化 dp[1] = 1。
 * <p>
 * i >= 2 时，dp[i] = max(dp[i], dp[i - j] * j, (i - j) * j)（j∈[0, i)）。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max((i - j) * j, Math.max(dp[i], dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
