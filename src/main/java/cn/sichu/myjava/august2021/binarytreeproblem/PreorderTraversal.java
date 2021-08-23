package cn.sichu.myjava.august2021.binarytreeproblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历 @see<a href = "https://leetcode-cn.com/problems/binary-tree-preorder-traversal">144. 二叉树的前序遍历</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * <strong>解法</strong>
 * <p>
 * <ol>
 * <li>递归遍历
 * <p>
 * 先访问根节点，接着递归左子树、右子树。
 * <li>栈实现非递归遍历
 * <p>
 * 非递归的思路如下：
 * <ol>
 * <li>定义一个栈，先将根节点压入栈
 * <li>若栈不为空，每次从栈中弹出一个节点
 * <li>处理该节点
 * <li>先把节点右孩子压入栈，接着把节点左孩子压入栈（如果有孩子节点）
 * <li>重复 2-4
 * <li>返回结果
 * </ol>
 * <li>Morris 实现前序遍历
 * <p>
 * Morris 遍历无需使用栈，空间复杂度为 O(1)。核心思想是：
 * <p>
 * 遍历二叉树节点，
 * <ol>
 * <li>若当前节点 root 的左子树为空，将当前节点值添加至结果列表 res 中，并将当前节点更新为 root.right
 * <li>若当前节点 root 的左子树不为空，找到左子树的最右节点 pre（也即是 root 节点在中序遍历下的前驱节点）：
 * <ul>
 * <li>若前驱节点 pre 的右子树为空，将当前节点值添加至结果列表 res 中，然后将前驱节点的右子树指向当前节点 root，并将当前节点更新为 root.left。
 * <li>若前驱节点 pre 的右子树不为空，将前驱节点右子树指向空（即解除 pre 与 root 的指向关系），并将当前节点更新为 root.right。
 * </ul>
 * </ol>
 * <li>循环以上步骤，直至二叉树节点为空，遍历结束。
 * </ol>
 * 
 * @author sichu
 * @date 2021/08/22
 */
public class PreorderTraversal {
    /**
     * recurse version
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    /**
     * non recurse
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> s = new LinkedList<>();
            s.offerLast(root);
            while (!s.isEmpty()) {
                TreeNode node = s.pollLast();
                res.add(node.val);
                if (node.right != null) {
                    s.offerLast(node.right);
                }
                if (node.left != null) {
                    s.offerLast(node.left);
                }
            }
        }
        return res;
    }
}
