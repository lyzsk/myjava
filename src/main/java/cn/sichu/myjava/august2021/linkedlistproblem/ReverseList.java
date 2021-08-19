package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 反转链表 @see<a href = "https://leetcode-cn.com/problems/reverse-linked-list">反转链表</a>
 * <p>
 * 题目描述
 * <p>
 * 反转一个单链表。 解法
 * <p>
 * 定义指针 p、q 分别指向头节点和下一个节点，pre 指向头节点的前一个节点。<br>
 * 遍历链表，改变指针 p 指向的节点的指向，将其指向 pre 指针指向的节点，即 p.next = pre。然后 pre 指针指向 p，p、q 指针往前走。<br>
 * 当遍历结束后，返回 pre 指针即可。
 * 
 * @author sichu
 * @date 2021/08/18
 */
public class ReverseList {
    /**
     * iterate version
     * 
     * @param head
     * @return pre
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;

        while (p != null) {
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;

        }
        return pre;
    }

    /**
     * recurse version
     * 
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
