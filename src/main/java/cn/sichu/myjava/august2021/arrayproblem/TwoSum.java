package cn.sichu.myjava.august2021.arrayproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 @see<a href = "https://leetcode-cn.com/problems/two-sum">两数之和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 用哈希表（字典）存放数组值以及对应的下标。
 * <p>
 * 遍历数组，当发现 target - nums[i] 在哈希表中，说明找到了目标值。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
