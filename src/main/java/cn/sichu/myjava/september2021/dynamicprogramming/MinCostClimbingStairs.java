package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 746. 使用最小花费爬楼梯 @see<a href = "https://leetcode-cn.com/problems/min-cost-climbing-stairs/">746. 使用最小花费爬楼梯</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * 
 * <pre>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * </pre>
 * 
 * 示例 2：
 * 
 * <pre>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * </pre>
 * 
 * @author sichu
 * @date 2021/09/05
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1] + cost[i]);
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }
}
