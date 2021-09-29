package cn.sichu.myjava.september2021.dynamicprogramming;

import java.util.List;

/**
 * 120. 三角形最小路径和 @see<a href = "https://leetcode-cn.com/problems/triangle/">120. 三角形最小路径和</a>
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
 * 。
 * <p>
 * 
 * @author sichu
 * @date 2021/09/29
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int min = Integer.MAX_VALUE;
                if (j > 0) {
                    min = Math.min(min, triangle.get(i - 1).get(j - 1));
                }
                if (j < i) {
                    min = Math.min(min, triangle.get(i - 1).get(j));
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int val : triangle.get(n - 1)) {
            res = Math.min(res, val);
        }
        return res;
    }
}
