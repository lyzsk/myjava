package cn.sichu.myjava.august2021.arrayproblem;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和 @see<a href = "https://leetcode-cn.com/problems/3sum-closest">最接近的三数之和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 双指针解决。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int tmp = twoSumClosest(nums, i + 1, n - 1, target - nums[i]);
            if (Math.abs(nums[i] + tmp - target) < diff) {
                res = nums[i] + tmp;
                diff = Math.abs(nums[i] + tmp - target);
            }
        }
        return res;
    }

    private int twoSumClosest(int[] nums, int start, int end, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;

        while (start < end) {
            int val = nums[start] + nums[end];
            if (val == target) {
                return val;
            }
            if (Math.abs(val - target) < diff) {
                res = val;
                diff = Math.abs(val - target);
            }
            if (val < target) {
                ++start;
            } else {
                --end;
            }
        }
        return res;
    }
}
