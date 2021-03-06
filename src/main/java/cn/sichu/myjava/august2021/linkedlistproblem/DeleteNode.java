package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 237. 删除链表中的节点 @see<a href = "https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">删除链表中的节点</a>
 * <p>
 * 题目描述:
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * <p>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * </ul>
 * </pre>
 * <p>
 * 示例 2：
 * <ul>
 * 
 * <pre>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * </ul>
 * </pre>
 * <p>
 * 提示：
 * <ul>
 * <li>链表至少包含两个节点。
 * <li>链表中所有节点的值都是唯一的。
 * <li>给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * <li>不要从你的函数中返回任何结果。
 * </ul>
 * <p>
 * 解法:
 * <p>
 * 将 node.next 节点的值赋给 node，然后将 node.next 指向 node.next 的下一个节点。
 * 
 * @author sichu
 *
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
