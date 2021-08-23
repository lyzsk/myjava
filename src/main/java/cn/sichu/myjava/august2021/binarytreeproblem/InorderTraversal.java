package cn.sichu.myjava.august2021.binarytreeproblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历 @see<a href = "https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <strong>解法</strong>
 * <ol>
 * <li>递归遍历
 * <p>
 * 先递归左子树，再访问根节点，接着递归右子树。
 * <li>栈实现非递归遍历
 * <p>
 * 非递归的思路如下：
 * <ol>
 * <li>定义一个栈
 * <li>将树的左节点依次入栈
 * <li>左节点为空时，弹出栈顶元素并处理
 * <li>重复 2-3 的操作
 * </ol>
 * <li>Morris 实现中序遍历
 * <p>
 * Morris 遍历无需使用栈，空间复杂度为 O(1)。核心思想是：
 * <p>
 * 遍历二叉树节点，
 * <ol>
 * <li>若当前节点 root 的左子树为空，将当前节点值添加至结果列表 res 中，并将当前节点更新为 root.right
 * <li>若当前节点 root 的左子树不为空，找到左子树的最右节点 pre（也即是 root 节点在中序遍历下的前驱节点）：
 * <ul>
 * <li>若前驱节点 pre 的右子树为空，将前驱节点的右子树指向当前节点 root，并将当前节点更新为 root.left。
 * <li>若前驱节点 pre 的右子树不为空，将当前节点值添加至结果列表 res 中，然后将前驱节点右子树指向空（即解除 pre 与 root 的指向关系），并将当前节点更新为 root.right。
 * </ul>
 * <li>循环以上步骤，直至二叉树节点为空，遍历结束。
 * </ol>
 * </ol>
 * 
 * @author sichu
 * @date 2021/08/22
 */
public class InorderTraversal {
    /**
     * recurse version
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    /**
     * Stack version
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalTwo(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new LinkedList<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.offerLast(root);
                root = root.left;
            } else {
                root = s.pollLast();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
