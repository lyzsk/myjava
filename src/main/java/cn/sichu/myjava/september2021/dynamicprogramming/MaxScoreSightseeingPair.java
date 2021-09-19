package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 1014. 最佳观光组合 @see<a href = "https://leetcode-cn.com/problems/best-sightseeing-pair/">1014. 最佳观光组合</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 
 * 
 * @author sichu
 * @date 2021/09/19
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, values[i] - i + max);
            max = Math.max(max, values[i] + i);
        }
        return res;
    }
}
