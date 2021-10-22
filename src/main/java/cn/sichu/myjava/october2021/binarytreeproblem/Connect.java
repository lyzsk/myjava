package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 116.
 * 填充每个节点的下一个右侧节点指针 @see<a href = "https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/">116.
 * 填充每个节点的下一个右侧节点指针</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
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
public class Connect {
    /**
     * 思路就是上层的next节点已经连接好了
     * 
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connectTwo(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node cur = null;
            for (int i = 0, n = q.size(); i < n; ++i) {
                Node node = q.pollFirst();
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                node.next = cur;
                cur = node;
            }
        }
        return root;
    }
}
