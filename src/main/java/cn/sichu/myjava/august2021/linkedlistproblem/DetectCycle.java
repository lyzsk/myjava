package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 142. 环形链表 II @see<a href = "https://leetcode-cn.com/problems/linked-list-cycle-ii/">142. 环形链表 II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <strong>进阶：</strong>
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？ <strong>解法</strong>
 * <p>
 * 先利用快慢指针判断链表是否有环，没有环则直接返回 null。
 * <p>
 * 若链表有环，我们分析快慢相遇时走过的距离。
 * <p>
 * 对于慢指针（每次走 1 步），走过的距离为 S=X+Y ①；快指针（每次走 2 步）走过的距离为 2S=X+Y+N(Y+Z) ②。如下图所示，其中 N 表示快指针与慢指针相遇时在环中所走过的圈数，而我们要求的环入口，也即是 X 的距离
 * <p>
 * 我们根据式子 ①②，得出 X+Y=N(Y+Z) => X=(N-1)(Y+Z)+Z。
 * <p>
 * 当 N=1(快指针在环中走了一圈与慢指针相遇) 时，X=(1-1)(Y+Z)+Z，即 X=Z。此时只要定义一个 p 指针指向头节点，然后慢指针与 p 开始同时走，当慢指针与 p 相遇时，也就到达了环入口，直接返回 p 即可。
 * <p>
 * 当 N>1时，也是同样的，说明慢指针除了走 Z 步，还需要绕 N-1 圈才能与 p 相遇。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (!hasCycle && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            hasCycle = slow == fast;
        }
        if (!hasCycle) {
            return null;
        }
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
