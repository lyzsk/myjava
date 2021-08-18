package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 对链表进行插入排序 @see<a href = "https://leetcode-cn.com/problems/insertion-sort-list">对链表进行插入排序</a>
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
 * 题目描述
 * <p>
 * 对链表进行插入排序。<br>
 * 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。<br>
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 示例 1：
 * <ul>
 * 输入: 4->2->1->3<br>
 * 输出: 1->2->3->4
 * </ul>
 * 示例 2：
 * <ul>
 * 输入: -1->5->3->4->0<br>
 * 输出: -1->0->3->4->5
 * </ul>
 * 解法:
 * <p>
 * 遍历链表，每次将遍历到的结点 cur 与前一个结点 pre 进行值比较：
 * <ul>
 * <li>若结点 cur 的值比 pre 的大，说明当前 cur 已在正确的位置，直接往下遍历。
 * <li>否则，从链表第一个结点开始遍历，将结点 cur 插入到正确的位置。
 * </ul>
 * 依次遍历，直至 cur 指向空，遍历结束。
 * 
 * @author sichu
 * @date 2021/08/17
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(head.val, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode p = dummy;
            while (p.next.val <= cur.val) {
                p = p.next;
            }
            ListNode tmp = cur.next;
            cur.next = p.next;
            p.next = cur;
            pre.next = tmp;
            cur = tmp;
        }
        return dummy.next;
    }

}
