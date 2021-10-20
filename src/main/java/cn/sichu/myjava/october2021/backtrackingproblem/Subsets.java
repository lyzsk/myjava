package cn.sichu.myjava.october2021.backtrackingproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集 @see<a href = "https://leetcode-cn.com/problems/subsets/">78. 子集</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 提示：
 * <ul>
 * <li>1 <= nums.length <= 10
 * <li>-10 <= nums[i] <= 10
 * <li>nums 中的所有元素 互不相同
 * </ul>
 * 解法
 * <p>
 * 回溯法的基本模板：
 * 
 * <pre>
 * <code>res = []</code>
 * <code>path = []</code>
 * <code>def backtrack(未探索区域, res, path):</code>
 * <code>    if path 满足条件:</code>
 * <code>        res.add(path) # 深度拷贝</code>
 * <code>        # return  # 如果不用继续搜索需要 return</code>
 * <code>    for 选择 in 未探索区域当前可能的选择:</code>
 * <code>        if 当前选择符合要求:</code>
 * <code>            path.add(当前选择)</code>
 * <code>            backtrack(新的未探索区域, res, path)</code>
 * <code>            path.pop()</code>
 * </pre>
 * 
 * @author sichu
 * @date 2021/10/20
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums, 0, res, path);
        return res;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<Integer>(path));
        while (start < nums.length) {
            path.add(nums[start]);
            dfs(nums, start + 1, res, path);
            path.remove(path.size() - 1);
            ++start;
        }
    }

}
