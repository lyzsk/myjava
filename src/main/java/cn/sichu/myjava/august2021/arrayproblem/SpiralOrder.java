package cn.sichu.myjava.august2021.arrayproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵 @see<a href = "https://leetcode-cn.com/problems/spiral-matrix">螺旋矩阵</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 从外往里一圈一圈遍历并存储矩阵元素即可。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class SpiralOrder {
    private List<Integer> res;

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        res = new ArrayList<>();
        int i1 = 0;
        int i2 = m - 1;
        int j1 = 0;
        int j2 = n - 1;
        while (i1 <= i2 && j1 <= j2) {
            add(matrix, i1++, j1++, i2--, j2--);
        }
        return res;
    }

    private void add(int[][] matrix, int i1, int j1, int i2, int j2) {
        if (i1 == i2) {
            for (int j = j1; j <= j2; ++j) {
                res.add(matrix[i1][j]);
            }
            return;
        }
        if (j1 == j2) {
            for (int i = i1; i <= i2; ++i) {
                res.add(matrix[i][j1]);
            }
            return;
        }
        for (int j = j1; j < j2; ++j) {
            res.add(matrix[i1][j]);
        }
        for (int i = i1; i < i2; ++i) {
            res.add(matrix[i][j2]);
        }
        for (int j = j2; j > j1; --j) {
            res.add(matrix[i2][j]);
        }
        for (int i = i2; i > i1; --i) {
            res.add(matrix[i][j1]);
        }
    }
}
