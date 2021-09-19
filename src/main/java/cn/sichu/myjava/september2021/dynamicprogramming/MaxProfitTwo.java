package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 122. 买卖股票的最佳时机 II @see<a href = "https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">122. 买卖股票的最佳时机
 * II</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 解法
 * <p>
 * 设 f1 表示当天结束后持有股票的最大利润，f2 表示当前结束后没有持有股票的最大利润。
 * <p>
 * 初始第 1 天结束时，f1 = -prices[0]，f2 = 0。
 * <p>
 * 从第 2 天开始，当天结束时：
 * <ul>
 * <li>若持有股票，则可能是前一天持有股票，然后继续持有；也可能是前一天没有持有股票，然后当天买入股票。最大利润 f1 = max(f1, f2 - prices[i])。
 * <li>若没有持有股票，则可能是前一天没持有股票，今天也没持有股票；或者前一天持有股票，然后今天卖出。最大利润 f2 = max(f2, f1 + prices[i])。
 * </ul>
 * 最后返回 f2 即可。
 * <p>
 * 
 * @author sichu
 * @date 2021/09/19
 */
public class MaxProfitTwo {
    public int maxProfit(int[] prices) {
        int f1 = -prices[0], f2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            f1 = Math.max(f1, f2 - prices[i]);
            f2 = Math.max(f2, f1 + prices[i]);
        }
        return f2;
    }
}
