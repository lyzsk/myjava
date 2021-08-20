package cn.sichu.myjava.august2021.arrayproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 四数之和 @see<a href = "https://leetcode-cn.com/problems/4sum">四数之和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * <strong>解法</strong>
 * <p>
 * “排序 + 双指针”实现。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            // a、b、c 和 d 互不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        --l;
                        while (k < n && nums[k] == nums[k - 1]) {
                            ++k;
                        }
                        while (i > j && nums[l] == nums[l + 1]) {
                            --l;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        ++k;
                    } else {
                        --l;
                    }
                }
            }
        }

        return res;
    }
}
