package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 面试题 26. 树的子结构 @see<a href = "https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/">面试题 26. 树的子结构</a>
 * <p>
 * 题目描述
 * <p>
 * 输入两棵二叉树 A 和 B，判断 B 是不是 A W 的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B 是 A 的子结构， 即 A 中有出现和 B 相同的结构和节点值。
 * <p>
 * 限制：
 * <ul>
 * <li>0 <= 节点个数 <= 10000
 * </ul>
 * 
 * @author sichu
 * @date 2021/10/14
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val != B.val) {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return sub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean sub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && sub(A.left, B.left) && sub(A.right, B.right);
    }
}
