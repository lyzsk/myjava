package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 121. 买卖股票的最佳时机 @see<a href = "https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 
 * @author sichu
 * @date 2021/09/19
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
