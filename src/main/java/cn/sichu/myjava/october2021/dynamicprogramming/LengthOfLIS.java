package cn.sichu.myjava.october2021.dynamicprogramming;

import java.util.Arrays;

/**
 * 300. 最长递增子序列 @see<a href = "https://leetcode-cn.com/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 提示：
 * <ul>
 * <li>1 <= nums.length <= 2500
 * <li>-104 <= nums[i] <= 104
 * </ul>
 * 进阶：
 * <ul>
 * <li>你可以设计时间复杂度为 O(n<sup>2</sup>) 的解决方案吗？
 * <li>你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * </ul>
 * 解法
 * <p>
 * 定义 dp[i] 为以 nums[i] 结尾的最长子序列的长度，dp[i] 初始化为 1(i∈[0, n))。即题目求的是 dp[i] （i ∈[0, n-1]）的最大值。
 * <p>
 * 状态转移方程为：
 * <p>
 * dp[i] = max(dp[j]) + 1，其中 0≤j<i 且 nums[j]<nums[i]。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class LengthOfLIS {
    /**
     * dp复杂度 O(n<sup>2</sup>)
     * 
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    /**
     * 二分法 O(nlogn)
     * 
     * @param nums
     * @return
     */
    public int lengthOfLISBinary(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] idx = new int[nums.length];
        idx[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > idx[len - 1]) {
                idx[len++] = nums[i];
            } else {
                int left = 0;
                int right = len - 1;
                while (left < right) {
                    int mid = left + ((right - left) >>> 1);
                    if (idx[mid] >= nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                idx[right] = nums[i];
            }
        }
        return len;
    }
}
