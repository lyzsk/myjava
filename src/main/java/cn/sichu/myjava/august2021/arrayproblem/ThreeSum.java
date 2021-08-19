package cn.sichu.myjava.august2021.arrayproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和 @see<a href = "https://leetcode-cn.com/problems/3sum">三数之和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <strong>解法</strong>
 * <p>
 * “排序 + 双指针”实现。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while (j < len && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                    while (k > i && nums[k] == nums[k + 1]) {
                        --k;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return res;
    }
}
