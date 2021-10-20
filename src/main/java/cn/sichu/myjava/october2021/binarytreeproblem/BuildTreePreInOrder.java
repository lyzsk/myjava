package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 @see<a href =
 * "https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105.
 * 从前序与中序遍历序列构造二叉树</a>
 * <p>
 * 题目描述
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * <p>
 * 你可以假设树中没有重复的元素。
 * <p>
 * 解法
 * <p>
 * 先遍历前序节点，对于前序的根节点，在中序节点 [i1, i2] 中找到根节点的位置 pos，就可以将中序节点分成：左子树 [i1, pos - 1]、右子树 [pos + 1, i2]。
 * <p>
 * 通过左右子树的区间，可以计算出左、右子树节点的个数，假设为 m、n。然后在前序节点中，从根节点往后的 m 个节点为左子树，再往后的 n 个节点为右子树。
 * <p>
 * 递归求解即可。
 * 
 * @author sichu
 * @date 2021/10/19
 */
public class BuildTreePreInOrder {

    private Map<Integer, Integer> indexes = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexes.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
        if (p1 > p2 || i1 > i2) {
            return null;
        }
        int rootVal = preorder[p1];
        int pos = indexes.get(rootVal);
        TreeNode node = new TreeNode(rootVal);

        // pos == i1, 说明只有右子树, 左子树为空
        node.left = pos == i1 ? null : build(preorder, inorder, p1 + 1, pos - i1 + p1, i1, pos - 1);
        // pos == i2, 说明只有左子树, 右子树为空
        node.right = pos == i2 ? null : build(preorder, inorder, pos - i1 + p1 + 1, p2, pos + 1, i2);
        return node;
    }
}
