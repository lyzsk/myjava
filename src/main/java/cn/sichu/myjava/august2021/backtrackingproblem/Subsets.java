package cn.sichu.myjava.august2021.backtrackingproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集 @see<a href = "https://leetcode-cn.com/problems/subsets/">78. 子集</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 回溯法:
 * 
 * <pre>
 * res = []
 * path = []
 * 
 *  def backtrack(未探索区域, res, path):
 *      if path 满足条件:
 *          res.add(path) # 深度拷贝
 *          # return  # 如果不用继续搜索需要 return
 *      for 选择 in 未探索区域当前可能的选择:
 *          if 当前选择符合要求:
 *              path.add(当前选择)
 *              backtrack(新的未探索区域, res, path)
 *              path.pop()
 * </pre>
 * 
 * @author sichu
 * @date 2021/08/23
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, path);
        return res;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        while (i < nums.length) {
            path.add(nums[i]);
            dfs(nums, i + 1, res, path);
            path.remove(path.size() - 1);
            ++i;
        }
    }

    /**
     * recurse version
     * <p>
     * 假设 nums 中的元素个数为 n ，每个元素两种情况：存在或不存在，则 nums 的子集个数为2<sup>n</sup>
     * <p>
     * 时间复杂度： <em>O</em>(n * 2<sup>n</sup>)，对于每个元素，每次操作最多复制所有子集
     * <p>
     * 空间复杂度： <em>O</em>(n * 2<sup>n</sup>)，最多有 2<sup>n</sup> 个子集，每个子集长度最多为 n
     * <p>
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsTwo(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 在res中加入空集
        res.add(new ArrayList<Integer>());
        // 遍历数组
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                // 复制结果中已经存在的子集
                List<Integer> newSubset = new ArrayList<Integer>(subset);
                // 加入当前整数
                newSubset.add(num);
                // 加入输出结果
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
        }
        return res;
    }
}
