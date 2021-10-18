package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 104. 二叉树的最大深度 @see <a href = "https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 解法
 * <p>
 * 递归遍历左右子树，求左右子树的最大深度 +1 即可。
 * 
 * @author sichu
 * @date 2021/10/18
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
