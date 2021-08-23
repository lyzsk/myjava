package cn.sichu.myjava.august2021.arrayproblem;

import java.util.Arrays;

/**
 * 259. 较小的三数之和 @see<a href = "">较小的三数之和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组 i, j, k 个数（0 <= i < j < k < n）。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 双指针解决。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += threeSumSmaller(nums, i + 1, nums.length - 1, target - nums[i]);
        }
        return count;
    }

    private int threeSumSmaller(int[] nums, int start, int end, int target) {
        int count = 0;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                count += (end - start);
                ++start;
            } else {
                --end;
            }
        }
        return count;
    }
}
