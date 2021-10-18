package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 111. 二叉树的最小深度 @see <a href = "https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 提示：
 * <ul>
 * <li>树中节点数的范围在 [0, 10<sup>5</sup>] 内
 * <li>-1000 <= Node.val <= 1000
 * </ul>
 * 解法：
 * <p>
 * 要注意如果左子树和右子树其中一个为空，那么需要返回比较大的那个子树的深度+1
 * 
 * @author sichu
 * @date 2021/10/18
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
}
