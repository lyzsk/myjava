package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 235.
 * 二叉搜索树的最近公共祖先 @see<a href = "https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">235.
 * 二叉搜索树的最近公共祖先</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 * <p>
 * 说明:
 * <ul>
 * <li>所有节点的值都是唯一的。
 * <li>p、q 为不同节点且均存在于给定的二叉搜索树中。
 * </ul>
 * 解法
 * <p>
 * 从上到下搜索，找到第一个值位于 [p, q] 之间的结点即可。既可以用迭代实现，也可以用递归实现。
 * 
 * @author sichu
 * @date 2021/10/22
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }
}
