package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 42. 接雨水 @see<a href = "https://leetcode-cn.com/problems/trapping-rain-water/submissions/">42. 接雨水</a>
 * <p>
 * 题目描述
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 解法
 * <p>
 * 对于下标 i，水能达到的最大高度等于下标 i 左右两侧的最大高度的最小值，再减去 height[i] 就能得到当前柱子所能存的水量。
 * 
 * @author sichu
 * @date 2021/09/27
 */
public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int[] lmx = new int[n];
        int[] rmx = new int[n];
        lmx[0] = height[0];
        rmx[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            lmx[i] = Math.max(lmx[i - 1], height[i]);
            rmx[n - 1 - i] = Math.max(rmx[n - i], height[n - i - 1]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(lmx[i], rmx[i]) - height[i];
        }
        return res;
    }
}
