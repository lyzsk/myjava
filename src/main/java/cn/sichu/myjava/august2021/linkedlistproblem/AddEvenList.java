package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 328. 奇偶链表 @see<a href = "https://leetcode-cn.com/problems/odd-even-linked-list/">328. 奇偶链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 <strong>说明:</strong>
 * <ul>
 * <li>应当保持奇数节点和偶数节点的相对顺序。
 * <li>链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * </ul>
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class AddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
