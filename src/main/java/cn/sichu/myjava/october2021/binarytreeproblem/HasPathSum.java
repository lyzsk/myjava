package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 112. 路径总和 @see <a href = "https://leetcode-cn.com/problems/path-sum/">112. 路径总和</a>
 * <p>
 * 题目描述
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 提示：
 * <ul>
 * <li>树中节点的数目在范围 [0, 5000] 内
 * <li>-1000 <= Node.val <= 1000
 * <li>-1000 <= targetSum <= 1000
 * </ul>
 * 解法
 * <p>
 * 递归求解，递归地询问它的子节点是否能满足条件即可
 * 
 * @author sichu
 * @date 2021/10/19
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
