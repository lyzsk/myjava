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
 * 题目描述:<ul>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。<br>
 * 返回同样按升序排列的结果链表。
 * </ul><p>
 * 示例 1：<ul><pre>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * </ul></pre><p>
 * 示例 2：<ul><pre>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * </ul></pre><p>
 * 提示：<ul>
 * <li>链表中节点数目在范围 [0, 300] 内
 * <li>-100 <= Node.val <= 100
 * <li>题目数据保证链表已经按升序排列
 * 
 */
public class DeleteDuplicatesII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1, head);
		ListNode cur = dummy;
		
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int val = cur.next.val;
				while (cur.next != null && cur.next.val == val) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
    }
}
