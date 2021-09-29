package cn.sichu.myjava.september2021.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II @see<a href = "https://leetcode-cn.com/problems/pascals-triangle-ii/">119. 杨辉三角 II</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 解法
 * <p>
 * 递推式 C<sup>i</sup><sub>n</sub> = C<sup>i</sup><sub>n-1</sub> + C<sup>i-1</sup><sub>n-1</sub> 表明，当前行第i项的计算只与第 i-1
 * 项有关，因此我们可以倒着计算当前行，这样计算到第i项时，第i-1项仍然是上一行的值
 * 
 * @author sichu
 * @date 2021/09/29
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
        }
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
