package cn.sichu.myjava.september2021.dynamicprogramming;

import java.util.Arrays;

/**
 * 62. 不同路径 @see<a href = "https://leetcode-cn.com/problems/unique-paths/">62. 不同路径</a>
 * <p>
 * 题目描述
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 解法
 * <p>
 * 假设 dp[i][j] 表示到达网格 (i,j) 的路径数，由于我们每一步只能从向下或者向右移动一步，因此要想走到 (i, j)，如果向下走一步，那么会从 (i-1, j) 走过来；如果向右走一步，那么会从 (i, j-1) 走过来。
 * <p>
 * 则 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]。
 * <p>
 * 需要注意的是，如果 i=0，那么 dp(i-1,j) 并不是一个满足要求的状态，我们需要忽略这一项；同理，如果 j=0，那么 dp(i,j-1) 并不是一个满足要求的状态，我们需要忽略这一项。
 * <p>
 * dp(i,j) 仅与第 i 行和第 i-1 行的状态有关，因此我们可以使用滚动数组代替代码中的二维数组，使空间复杂度降低为 O(n)。此外，由于我们交换行列的值并不会对答案产生影响，因此我们总可以通过交换 m 和 n 使得 m ≤
 * n，这样空间复杂度降低至 O(min(m, n))。
 * 
 * @author sichu
 * @date 2021/09/30
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
