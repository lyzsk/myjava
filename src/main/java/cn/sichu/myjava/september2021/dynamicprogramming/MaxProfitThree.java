package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 123. 买卖股票的最佳时机 III @see<a href = "https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/">123.
 * 买卖股票的最佳时机 III</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 解法
 * <p>
 * 设 f1 表示第 1 次买入股票后的最大利润，f2 表示第 1 次卖出股票后的最大利润，f3 表示第 2 次买入股票后的最大利润，f4 表示第 2 次卖出股票后的最大利润。
 * <p>
 * 遍历过程中，直接使用 f1, f2, f3, f4 计算，考虑的是在同一天买入和卖出时，收益是 0，不会对答案产生影响。
 * <p>
 * 最后返回 f4 即可。
 * 
 * @author sichu
 * @date 2021/09/19
 */
public class MaxProfitThree {
    public int maxProfit(int[] prices) {
        int f1 = -prices[0];
        int f2 = 0;
        int f3 = -prices[0];
        int f4 = 0;
        for (int i = 1; i < prices.length; i++) {
            f1 = Math.max(f1, -prices[i]);
            f2 = Math.max(f2, f1 + prices[i]);
            f3 = Math.max(f3, f2 - prices[i]);
            f4 = Math.max(f4, f3 + prices[i]);
        }
        return f4;
    }
}
