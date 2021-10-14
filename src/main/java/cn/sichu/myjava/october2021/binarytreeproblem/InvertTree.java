package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 226. 翻转二叉树 @see<a href = "">226. 翻转二叉树</a>
 * <p>
 * 题目描述
 * <p>
 * 翻转一棵二叉树。
 * 
 * @author sichu
 * @date 2021/10/14
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
