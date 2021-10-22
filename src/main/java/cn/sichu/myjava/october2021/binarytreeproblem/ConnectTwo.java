package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 117. 填充每个节点的下一个右侧节点指针
 * II @see<a href = "https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/">117.
 * 填充每个节点的下一个右侧节点指针 II</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉树
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 进阶：
 * <ul>
 * <li>你只能使用常量级额外空间。
 * <li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * </ul>
 * 解法
 * <p>
 * “BFS 层次遍历”实现。
 * 
 * @author sichu
 * @date 2021/10/22
 */
public class ConnectTwo {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        if (root.next != null) {
            return getNext(root.next);
        }
        return null;
    }

    public Node connectTwo(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Deque<Node> s = new ArrayDeque<Node>();
        s.offerLast(root);
        while (!s.isEmpty()) {
            Node cur = null;
            for (int i = 0, n = s.size(); i < n; i++) {
                Node node = s.pollFirst();
                if (node.right != null) {
                    s.offerLast(node.right);
                }
                if (node.left != null) {
                    s.offerLast(node.left);
                }
                node.next = cur;
                cur = node;
            }
        }
        return root;
    }
}
