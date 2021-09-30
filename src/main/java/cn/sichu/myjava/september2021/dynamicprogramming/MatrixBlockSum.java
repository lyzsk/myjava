package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 1314. 矩阵区域和 @see<a href = "https://leetcode-cn.com/problems/matrix-block-sum/">1314. 矩阵区域和</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * <ul>
 * <li>i - K <= r <= i + K, j - K <= c <= j + K
 * <li>(r, c) 在矩阵内。
 * </ul>
 * 
 * TODO: 为什么我他妈一个字都看不懂？？？？
 * 
 * @author sichu
 * @date 2021/09/29
 */
public class MatrixBlockSum {
    private int[][] pre;
    private int m;
    private int n;

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + -pre[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        this.pre = pre;
        this.m = m;
        this.n = n;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] =
                    get(i + k + 1, j + k + 1) - get(i + k + 1, j - k) - get(i - k, j + k + 1) + get(i - k, j - k);
            }
        }
        return ans;
    }

    private int get(int i, int j) {
        i = Math.max(Math.min(m, i), 0);
        j = Math.max(Math.min(n, j), 0);
        return pre[i][j];
    }
}
