package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II @see<a href = "https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">107. 二叉树的层序遍历
 * II</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 解法
 * <p>
 * 同 @see<a href = "https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/">102
 * </a>，最后反转一下结果即可。
 * 
 * @author sichu
 * @date 2021/10/14
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offerLast(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<Integer>();
            while (size-- > 0) {
                TreeNode node = q.pollFirst();
                tmp.add(node.val);
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
            res.add(0, tmp);
        }
        return res;
    }
}
