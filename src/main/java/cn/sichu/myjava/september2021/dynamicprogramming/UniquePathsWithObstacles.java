package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 63. 不同路径 II @see<a href = "https://leetcode-cn.com/problems/unique-paths-ii/">63. 不同路径 II</a>
 * <p>
 * 题目描述
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 解法
 * <p>
 * 假设 dp[i][j] 表示到达网格 (i,j) 的路径数，先初始化 dp 第一列和第一行的所有值，然后判断。
 * <ul>
 * <li>若 obstacleGrid[i][j] == 1，说明路径数为 0，dp[i][j] = 0；
 * <li>若 obstacleGrid[i][j] == 0，则 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]。
 * </ul>
 * 最后返回 dp[m - 1][n - 1] 即可。
 * 
 * @author sichu
 * @date 2021/09/30
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
