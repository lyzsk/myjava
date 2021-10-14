package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 102. 二叉树的层序遍历 @see<a href = "https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/">102.
 * 二叉树的层序遍历</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * @author sichu
 * @date 2021/10/14
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.pollFirst();
                t.add(node.val);
                if (node.left != null)
                    q.offerLast(node.left);
                if (node.right != null)
                    q.offerLast(node.right);
            }
            res.add(t);
        }
        return res;
    }
}
