package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. 路径总和 II @see<a href = "https://leetcode-cn.com/problems/path-sum-ii/">113. 路径总和 II</a>
 * <p>
 * 题目描述
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 提示：
 * <ul>
 * <li>树中节点的数目在范围 [0, 5000] 内
 * <li>-1000 <= Node.val <= 1000
 * <li>-1000 <= targetSum <= 1000
 * </ul>
 * 解法
 * <p>
 * 深度优先搜索+路径记录。
 * 
 * @author sichu
 * @date 2021/10/19
 */
public class PathSum {

    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        res = new ArrayList<List<Integer>>();
        path = new ArrayList<Integer>();
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(path));
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
