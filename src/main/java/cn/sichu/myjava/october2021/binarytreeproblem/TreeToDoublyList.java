package cn.sichu.myjava.october2021.binarytreeproblem;

/**
 * 
 * 426. 将二叉搜索树转化为排序的双向链表 @see<a href =
 * "https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">426. 将二叉搜索树转化为排序的双向链表</a>
 * <p>
 * 题目描述
 * <p>
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 * <p>
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 * <p>
 * 提示：
 * <ul>
 * <li>-1000 <= Node.val <= 1000
 * <li>Node.left.val < Node.val < Node.right.val
 * <li>Node.val 的所有值都是独一无二的
 * <li>0 <= Number of Nodes <= 2000
 * </ul>
 * 解法
 * <ul>
 * <li>排序链表：二叉搜索树中序遍历得到有序序列
 * <li>循环链表：头节点指向链表尾节点，尾节点指向链表头节点
 * <li>双向链表：pre.right = cur、cur.left = pre、pre = cur
 * </ul>
 * 
 * @author sichu
 * @date 2021/10/22
 */
public class TreeToDoublyList {
    private Node head;
    private Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
