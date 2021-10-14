package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 199. 二叉树的右视图 @see<a href = "">199. 二叉树的右视图</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 解法
 * <p>
 * 队列实现。
 * 
 * @author sichu
 * @date 2021/10/14
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().val);

            while (size-- > 0) {
                TreeNode node = q.pollFirst();
                if (node.right != null) {
                    q.offerLast(node.right);
                }
                if (node.left != null) {
                    q.offerLast(node.left);
                }
            }
        }
        return res;
    }
}
