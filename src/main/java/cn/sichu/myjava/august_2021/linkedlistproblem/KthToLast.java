package cn.sichu.myjava.august_2021.linkedlistproblem;

/**
 * <pre>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * </pre>
 * 
 * <strong>题目描述:</strong><p>
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 示例：<ul><pre>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * </ul></pre><p>
 * <strong>说明：</strong><p>
 * 给定的 k 保证是有效的。
 * <p>
 * <strong>解法:</strong><p>
 * 定义 p、q 指针指向 head。<br>
 * p 先向前走 k 步，接着 p、q 同时向前走，当 p 指向 null 时，q 指向的节点即为链表的倒数第 k 个节点。
 * 
 */
public class KthToLast {
	public int kthToLast(ListNode head, int k) {
		ListNode fast = head, slow = head;
		while (k --> 0) {
			fast = fast.next;
		}
		
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.val;
    }
}
