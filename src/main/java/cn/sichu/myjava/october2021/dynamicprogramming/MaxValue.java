package cn.sichu.myjava.october2021.dynamicprogramming;

/**
 * 面试题 47. 礼物的最大价值 @see<a href = "https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/">面试题 47. 礼物的最大价值</a>
 * <p>
 * 题目描述
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于
 * 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 提示：
 * <ul>
 * <li>0 < grid.length <= 200
 * <li>0 < grid[0].length <= 200
 * </ul>
 * 解法
 * <p>
 * 动态规划法。
 * <p>
 * 
 * 我们假设 dp[i][j] 表示走到格子 (i, j) 的礼物最大累计价值，则 dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 不好理解
     * 
     * @param grid
     * @return
     */
    public int maxValueTwo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }
}
