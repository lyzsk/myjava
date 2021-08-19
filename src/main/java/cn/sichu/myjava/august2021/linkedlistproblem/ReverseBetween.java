package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 反转链表 II @see<a href = "https://leetcode-cn.com/problems/reverse-linked-list-ii">反转链表II<a>
 * </p>
 * 题目描述:
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。 <br>
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 
 * @author sichu
 * @date 2021/08/18
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode p = pre;
        ListNode q = pre.next;
        ListNode cur = q;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        p.next = pre;
        q.next = cur;
        return dummy.next;
    }
}
