package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 53. 最大子序和 @see<a href = "https://leetcode-cn.com/problems/maximum-subarray/">53. 最大子序和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个整数数组 <code>nums</code> ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 
 * <pre>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * </pre>
 * 
 * <pre>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * </pre>
 * 
 * <pre>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * </pre>
 * 
 * <pre>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * </pre>
 * 
 * <pre>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 * </pre>
 * 
 * <strong>解法</strong>
 * <ol>
 * <li>动态规划
 * <p>
 * 设 dp[i] 表示 [0..i] 中，以 nums[i] 结尾的最大子数组和，状态转移方程 dp[i] = nums[i] + max(dp[i - 1], 0)。
 * <p>
 * 由于 dp[i] 只与子问题 dp[i-1] 有关，故可以用一个变量 f 来表示。
 * <li>分治
 * <p>
 * 最大子序和可能有三种情况：
 * <ol>
 * <li>在数组左半部分
 * <li>在数组右半部分
 * <li>跨越左右半部分
 * </ol>
 * 递归求得三者，返回最大值即可。
 * </ol>
 * 
 * @author sichu
 * @date 2021/09/08
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int f = nums[0];
        int res = nums[0];
        for (int i = 1, n = nums.length; i < n; i++) {
            f = nums[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }
}
