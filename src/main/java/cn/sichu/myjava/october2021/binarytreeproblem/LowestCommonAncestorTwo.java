package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 236. 二叉树的最近公共祖先 @see<a href = "https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">236.
 * 二叉树的最近公共祖先</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 提示：
 * <ul>
 * <li>树中节点数目在范围 [2, 10<sup>5</sup>] 内。
 * <li>-10<sup>9</sup> <= Node.val <= 10<sup>9</sup>
 * <li>所有 Node.val 互不相同 。
 * <li>p != q
 * <li>p 和 q 均存在于给定的二叉树中。
 * </ul>
 * 解法
 * <p>
 * 根据“最近公共祖先”的定义，若 root 是 p, q 的最近公共祖先 ，则只可能为以下情况之一：
 * <ul>
 * <li>如果 p 和 q 分别是 root 的左右节点，那么 root 就是我们要找的最近公共祖先；
 * <li>如果 p 和 q 都是 root 的左节点，那么返回 lowestCommonAncestor(root.left, p, q)；
 * <li>如果 p 和 q 都是 root 的右节点，那么返回 lowestCommonAncestor(root.right, p, q)。
 * </ul>
 * 边界条件讨论：
 * <ul>
 * <li>如果 root 为 null，则说明我们已经找到最底了，返回 null 表示没找到；
 * <li>如果 root 与 p 相等或者与 q 相等，则返回 root；
 * <li>如果左子树没找到，递归函数返回 null，证明 p 和 q 同在 root 的右侧，那么最终的公共祖先就是右子树找到的结点；
 * <li>如果右子树没找到，递归函数返回 null，证明 p 和 q 同在 root 的左侧，那么最终的公共祖先就是左子树找到的结点。
 * </ul>
 * 
 * @author sichu
 * @date 2021/10/22
 */
public class LowestCommonAncestorTwo {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
