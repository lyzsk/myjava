package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 213. 打家劫舍 II @see<a href = "https://leetcode-cn.com/problems/house-robber-ii/">213. 打家劫舍 II</a>
 * <p>
 * 题目描述
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 解法
 * <p>
 * 环状排列意味着第一个房屋和最后一个房屋中最多只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房屋子问题。
 * 
 * @author sichu
 * @date 2021/09/05
 */
public class RobTwo {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int s1 = robRange(nums, 0, nums.length - 2);
        int s2 = robRange(nums, 1, nums.length - 1);
        return Math.max(s1, s2);
    }

    private int robRange(int[] nums, int l, int r) {
        int a = 0;
        int b = nums[l];
        for (int i = l + 1; i <= r; i++) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return b;
    }
}
