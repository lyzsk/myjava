package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * <strong>198. 打家劫舍</strong> @see<a href = "https://leetcode-cn.com/problems/house-robber/">198. 打家劫舍</a>
 * <p>
 * 题目描述
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 解法
 * <p>
 * 动态规划法。状态转移方程：f(n) = Math.max(f(n - 2) + nums[n], nums[n - 1])。
 * 
 * @author sichu
 * @date 2021/09/05
 */
public class Rob {
    public int rob(int[] nums) {
        // int a = 0;
        // int b = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        // int c = Math.max(nums[i] + a, b);
        // a = b;
        // b = c;
        // }
        // return b;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
