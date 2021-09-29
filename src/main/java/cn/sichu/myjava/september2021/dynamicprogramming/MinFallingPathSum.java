package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 931. 下降路径最小和 @see<a href = "https://leetcode-cn.com/problems/minimum-falling-path-sum/">931. 下降路径最小和</a>
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row
 * + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * 
 * @author sichu
 * @date 2021/09/29
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i - 1][j];
                if (j > 0) {
                    min = Math.min(min, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    min = Math.min(min, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, matrix[n - 1][j]);
        }
        return res;
    }
}
