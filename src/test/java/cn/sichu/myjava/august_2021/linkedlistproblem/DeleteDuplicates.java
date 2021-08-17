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
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。<br>
 * 返回同样按升序排列的结果链表。</ul>
 * <p>
 * 示例 1：<ul><pre>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * </ul></pre><p>
 * 示例 2：<ul><pre>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * </ul></pre><p>
 * 提示：<ul>
 * <li>链表中节点数目在范围 [0, 300] 内
 * <li>-100 <= Node.val <= 100
 * <li>题目数据保证链表已经按升序排列
 * </ul>
 * 
 */
public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
    }
}
