package cn.sichu.myjava.august_2021.linkedlistproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目描述:<p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。<br>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶：<p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例：<ul><pre>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * </ul></pre><p>
 * 解法:<p>
 * 利用栈将数字逆序。
 * 
 * @author sichu
 *
 */
public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> s1 = new ArrayDeque<>();
		Deque<Integer> s2 = new ArrayDeque<>();
		
		for (; l1 != null; l1 = l1.next) {
			s1.push(l1.val);
		}
		for (; l2 != null; l2 = l2.next) {
			s2.push(l2.val);
		}
		
		int carry = 0;
		ListNode dummy = new ListNode(-1);
		
		while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
			carry += (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop());
			ListNode node = new ListNode(carry % 10);
			node.next = dummy.next;
			dummy.next = node;
			carry /= 10;
		}
		return dummy.next;
	}
}
