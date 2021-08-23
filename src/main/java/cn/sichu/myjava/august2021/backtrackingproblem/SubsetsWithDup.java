package cn.sichu.myjava.august2021.backtrackingproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II @see<a href = "https://leetcode-cn.com/problems/subsets-ii/">90. 子集 II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 * @author sichu
 * @date 2021/08/23
 */
public class SubsetsWithDup {
    /**
     * 迭代法实现子集枚举
     * <p>
     * 考虑数组 [1,2,2][1,2,2]，选择前两个数，或者第一、三个数，都会得到相同的子集。
     * <p>
     * 也就是说，对于当前选择的数 x，若前面有与其相同的数 y，且没有选择 y，此时包含 x 的子集，必然会出现在包含 y 的所有子集中。
     * <p>
     * 我们可以通过判断这种情况，来避免生成重复的子集。代码实现时，可以先将数组排序；迭代时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
     * <p>
     * TODO 我不会我不懂我是谁？
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                res.add(new ArrayList<Integer>(t));
            }
        }
        return res;
    }
}
