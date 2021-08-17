package cn.sichu.myjava.august_2021.linkedlistproblem;

/**
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
 * <strong>题目描述</strong><p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。<br>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：<ul><pre>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * </ul></pre></p>
 * 示例 2：<ul><pre>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * </ul></pre></p>
 * 示例 3：<ul><pre>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * </ul></pre></p>
 * 提示：<ul>
 * <li>每个链表中的节点数在范围 [1, 100] 内
 * <li>0 <= Node.val <= 9
 * <li>题目数据保证列表表示的数字不含前导零
 * 
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		int carry = 0;
		ListNode cur = dummy;
		
		while (l1 != null || l2 != null || carry != 0) {
			int s = (l1 == null ? 0 : l1.val) 
					+ (l2 == null ? 0 : l2.val)
					+ carry;
			carry = s / 10;
			cur.next = new ListNode(s % 10);
			cur = cur.next;
			l1 = (l1 == null ? null : l1.next);
			l2 = (l2 == null ? null : l2.next);
		}
		return dummy.next;
	}
}
