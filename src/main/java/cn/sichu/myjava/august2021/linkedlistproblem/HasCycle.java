package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 141. 环形链表 @see<a href = "https://leetcode-cn.com/problems/linked-list-cycle/">141. 环形链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * <strong>进阶：</strong>
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * <strong>解法</strong>
 * <p>
 * 定义快慢指针 slow、fast，初始指向 head。
 * <p>
 * 快指针每次走两步，慢指针每次走一步，不断循环。当相遇时，说明链表存在环。如果循环结束依然没有相遇，说明链表不存在环。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
