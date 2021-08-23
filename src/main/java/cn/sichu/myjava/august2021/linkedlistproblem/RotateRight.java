package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 61. 旋转链表 @see<a href = "https://leetcode-cn.com/problems/rotate-list/">61. 旋转链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 将链表右半部分的 k 的节点拼接到 head 即可。
 * <p>
 * 
 * 注：k 对链表长度 n 取余，即 k %= n。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ++n;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode start = slow.next;
        slow.next = null;
        fast.next = head;
        return start;
    }
}
