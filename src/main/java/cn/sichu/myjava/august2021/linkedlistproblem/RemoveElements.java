package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 203. 移除链表元素 @see<a href = "https://leetcode-cn.com/problems/remove-linked-list-elements">移除链表元素</a>
 * <p>
 * 
 * <pre>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 * 
 * 题目描述:
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ， 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * </ul>
 * </pre>
 * <p>
 * 示例 2：
 * <ul>
 * 
 * <pre>
 * 输入：head = [], val = 1
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 示例 3：
 * <ul>
 * 
 * <pre>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 提示：
 * <ul>
 * <li>列表中的节点在范围 [0, 10<sup>4</sup>] 内
 * <li>1 <= Node.val <= 50
 * <li>0 <= k <= 50
 * </ul>
 * 
 * @author sichu
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (pre != null && pre.next != null) {
            if (pre.next.val != val) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return dummy.next;
    }
}
