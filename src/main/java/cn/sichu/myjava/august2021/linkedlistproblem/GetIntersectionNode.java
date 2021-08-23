package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 160. 相交链表 @see<a href = "">160. 相交链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <strong>注意：</strong>
 * <ol>
 * <li>如果两个链表没有交点，返回 null.
 * <li>在返回结果后，两个链表仍须保持原有的结构。
 * <li>可假定整个链表结构中没有循环。
 * <li>程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * </ol>
 * <strong>解法</strong>
 * <p>
 * 使用两个指针 cur1, cur2 分别指向两个链表 headA, headB。
 * <p>
 * 同时遍历链表，当 cur1 到达链表 headA 的末尾时，重新定位到链表 headB 的头节点；当 cur2 到达链表 headB 的末尾时，重新定位到链表 headA 的头节点。
 * <p>
 * 若两指针相遇，所指向的结点就是第一个公共节点。若没相遇，说明两链表无公共节点，此时两个指针都指向 null。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur1;
    }
}
