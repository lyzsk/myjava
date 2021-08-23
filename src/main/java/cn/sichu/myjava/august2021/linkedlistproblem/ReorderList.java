package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 143. 重排链表 @see<a href = "https://leetcode-cn.com/problems/reorder-list/">143. 重排链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个单链表 L：L<sub>0</sub>→L<sub>1</sub>→…→L<sub>n-1</sub>→L<sub>n</usb> ，
 * <p>
 * 将其重新排列后变为： L<sub>0</sub>→L<sub>n</sub>→L<sub>1</sub>→L<sub>n-1</sub>→L<sub>2</sub>→L<sub>n-2</sub>→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 先通过快慢指针找到链表中点，将链表划分为左右两部分。之后反转右半部分的链表，然后将左右两个链接依次连接即可。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class ReorderList {
    /**
     * <ol>
     * <li>当快指针fast向前移动的条件是：fast.next != null && fast.next.next != null时：
     * <p>
     * 
     * 输入：[1,2,3,4,5]
     * <p>
     * 
     * 对于节点个数为奇数的链表来说，此时链表的中间节点是节点3。 对于节点个数为偶数的链表来说，此时链表的中间节点是节点2，即在2和3这两个中间节点中，找到是第一个中间节点。 <oi>
     * <li>当快指针fast向前移动的条件是：fast != null && fast.next != null时：
     * <p>
     * 输入：[1,2,3,4]
     * <p>
     * 对于节点个数为奇数的链表来说，此时链表的中间节点是节点3。
     * 
     * 对于节点个数为偶数的链表来说，此时链表的中间节点是节点3，即在2和3这两个中间节点中，找到是第二个中间节点。
     * </ol>
     * 
     * 题目要求的是如果有两个中间节点，则返回第二个中间节点。因此，对于该题目而言，快指针fast向前移动的条件是：fast != null && fast.next != null。
     * <p>
     * 
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
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
        cur = head;

        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = tmp;
        }
    }
}
