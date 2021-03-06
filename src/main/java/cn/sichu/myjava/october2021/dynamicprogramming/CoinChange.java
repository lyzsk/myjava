package cn.sichu.myjava.october2021.dynamicprogramming;

import java.util.Arrays;

/**
 * 322. 零钱兑换 @see<a href = "https://leetcode-cn.com/problems/coin-change/">322. 零钱兑换</a>
 * <p>
 * 题目描述
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 提示：
 * <ul>
 * 
 * <li>1 <= coins.length <= 12
 * <li>1 <= coins[i] <= 231 - 1
 * <li>0 <= amount <= 104
 * </ul>
 * 解法
 * <p>
 * 动态规划。
 * <p>
 * 
 * 类似完全背包的思路，硬币数量不限，求凑成总金额所需的最少的硬币个数。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 最多的硬币情况是全部是1元，共有amount个硬币，共有amount+1个状态，amount+1个金额
        int[] dp = new int[amount + 1];
        // 必须将所有的dp赋最大值，因为要找最小值
        Arrays.fill(dp, amount + 1);
        // 自底向上，金额为0，最小硬币数为0
        dp[0] = 0;
        // 遍历coins的金额
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        // 返回金额为amount的最小硬币数 根据测试用例判断dp[amount] > amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
