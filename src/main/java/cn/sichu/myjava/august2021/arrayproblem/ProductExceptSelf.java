package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 除自身以外数组的乘积 @see<a href = "https://leetcode-cn.com/problems/product-of-array-except-self">除自身以外数组的乘积</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        for (int i = 0, left = 1; i < len; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int i = len - 1, right = 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
