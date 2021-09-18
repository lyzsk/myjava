package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 1567. 乘积为正数的最长子数组长度 @see<a href =
 * "https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/">1567. 乘积为正数的最长子数组长度</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 * 
 * @author sichu
 * @date 2021/09/18
 */
public class GetMaxLen {
    public int getMaxLen(int[] nums) {
        int f1 = nums[0] > 0 ? 1 : 0;
        int f2 = nums[0] < 0 ? 1 : 0;
        int res = f1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                ++f1;
                f2 = f2 > 0 ? f2 + 1 : 0;
            } else if (nums[i] < 0) {
                int pf1 = f1;
                int pf2 = f2;
                f2 = pf1 + 1;
                f1 = pf2 > 0 ? pf2 + 1 : 0;
            } else {
                f1 = 0;
                f2 = 0;
            }
            res = Math.max(res, f1);
        }
        return res;
    }
}
