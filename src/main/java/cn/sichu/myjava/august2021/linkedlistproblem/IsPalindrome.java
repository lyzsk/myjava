package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 234. 回文链表 @see<a href = "https://leetcode-cn.com/problems/palindrome-linked-list/">234. 回文链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 请判断一个链表是否为回文链表。 <strong>解法</strong>
 * <p>
 * 先用快慢指针找到链表的中点，接着反转右半部分的链表。然后同时遍历前后两段链表，若前后两段链表节点对应的值不等，说明不是回文链表，否则说明是回文链表。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
