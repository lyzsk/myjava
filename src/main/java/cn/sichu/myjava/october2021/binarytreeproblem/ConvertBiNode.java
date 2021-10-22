package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 面试题 17.12. BiNode @see<a href = "https://leetcode-cn.com/problems/binode-lcci/">面试题 17.12. BiNode</a>
 * <p>
 * 题目描述
 * <p>
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 解法
 * <p>
 * 递归将左子树、右子树转换为左、右链表 left 和 right。然后将左链表 left 的最后一个结点的 right 指针指向 root，root 的 right 指针指向右链表 right，并将 root 的 left 指针值为空。
 * 
 * @author sichu
 * @date 2021/10/22
 */
public class ConvertBiNode {
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = convertBiNode(root.left);
        TreeNode right = convertBiNode(root.right);

        if (left == null) {
            root.right = right;
            return root;
        }

        TreeNode res = left;
        while (left != null && left.right != null) {
            left = left.right;
        }

        left.right = root;
        root.right = right;
        root.left = null;

        return res;
    }
}
