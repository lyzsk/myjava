package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 264. 丑数 II @see<a href = "">264. 丑数 II</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 解法
 * <p>
 * 定义数组 dp，dp[i - 1] 表示第 i 个丑数，那么第 n 个丑数就是 dp[n - 1]。最小的丑数是 1，所以 dp[0] = 1。
 * <p>
 * 定义 3 个指针 p2，p3，p5，表示下一个丑数是当前指针指向的丑数乘以对应的质因数。初始时，三个指针的值都指向 0。
 * <p>
 * 当 i∈[1,n)，dp[i] = min(dp[p2] * 2, dp[p3] * 3, dp[p5] * 5)，然后分别比较 dp[i] 与 dp[p2] * 2、dp[p3] * 3、dp[p5] * 5
 * 是否相等，若是，则对应的指针加 1。
 * <p>
 * 最后返回 dp[n - 1] 即可。
 * 
 * @author sichu
 * @date 2021/09/27
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = dp[p2] * 2;
            int next3 = dp[p3] * 3;
            int next5 = dp[p5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                ++p2;
            }
            if (dp[i] == next3) {
                ++p3;
            }
            if (dp[i] == next5) {
                ++p5;
            }
        }
        return dp[n - 1];
    }
}
