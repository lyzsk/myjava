package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 257. 二叉树的所有路径 @see <a href = "https://leetcode-cn.com/problems/binary-tree-paths/">257. 二叉树的所有路径</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 解法
 * <p>
 * 深度优先搜索+路径记录。
 * 
 * TODO: 回溯？
 * 
 * @author sichu
 * @date 2021/10/18
 */
public class BinaryTreePaths {

    private List<String> res;
    private List<String> path;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        res = new ArrayList<String>();
        path = new ArrayList<String>();
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
        }
        dfs(root.left);
        dfs(root.right);
        path.remove(path.size() - 1);
    }
}
