package cn.sichu.myjava.october2021.binarytreeproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器 @see<a href = "https://leetcode-cn.com/problems/binary-search-tree-iterator/">173. 二叉搜索树迭代器<a>
 * <p>
 * 题目描述
 * <p>
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * <ul>
 * <li>BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST
 * 中的任何元素。
 * <li>boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * <li>int next()将指针向右移动，然后返回指针处的数字。
 * </ul>
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * 进阶：
 * <ul>
 * <li>你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。
 * </ul>
 * 解法
 * <p>
 * 初始化数据时，递归中序遍历，将二叉搜索树每个结点的值保存在列表 vals 中。用 cur/next 指针记录外部即将遍历的位置，初始化为 0。
 * <p>
 * 调用 next() 时，返回 vals[cur]，同时 cur 指针自增。调用 hasNext() 时，判断 cur 指针是否已经达到 vals 个数，若是，说明已经遍历结束，返回 false，否则返回 true。
 * 
 * @author sichu
 * @date 2021/10/21
 */
public class BSTIterator {

    private List<Integer> val;
    private int cur;

    public BSTIterator(TreeNode root) {
        cur = 0;
        val = new ArrayList<Integer>();
        inorderTraversal(root, val);
    }

    public int next() {
        return val.get(cur++);
    }

    public boolean hasNext() {
        return cur < val.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> val) {
        if (root != null) {
            inorderTraversal(root.left, val);
            val.add(root.val);
            inorderTraversal(root.right, val);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * <p>
 * <code>
 * BSTIterator obj = new BSTIterator(root);
 * 
 * int param_1 = obj.next();
 * 
 * boolean param_2 = obj.hasNext();
 * </code>
 */