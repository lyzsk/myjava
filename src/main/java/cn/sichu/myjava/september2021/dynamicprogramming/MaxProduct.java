package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 152. 乘积最大子数组 @see<a href = "https://leetcode-cn.com/problems/maximum-product-subarray/">152. 乘积最大子数组</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 解法
 * <p>
 * 考虑当前位置 i：
 * <ul>
 * <li>如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。
 * <li>如果是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
 * </ul>
 * 因此，分别维护 fmax 和 fmin。
 * <ul>
 * <li><code>fmax(i) = max(nums[i], fmax(i - 1) * nums[i], fmin(i - 1) * nums[i])</code>
 * <li><code>fmin(i) = min(nums[i], fmax(i - 1) * nums[i], fmin(i - 1) * nums[i])</code>
 * <li>res = max(fmax(i)), i∈[0, n)
 * </ul>
 * 
 * @author sichu
 * @date 2021/09/18
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int fmax = nums[0];
        int fmin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int m = fmax;
            int n = fmin;
            fmax = Math.max(nums[i], Math.max(m * nums[i], n * nums[i]));
            fmin = Math.min(nums[i], Math.min(m * nums[i], n * nums[i]));
            res = Math.max(res, fmax);
        }
        return res;
    }
}
