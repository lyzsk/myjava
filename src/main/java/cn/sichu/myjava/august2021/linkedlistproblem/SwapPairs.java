package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 24. 两两交换链表中的节点 @see<a href = "https://leetcode-cn.com/problems/swap-nodes-in-pairs">两两交换链表中的节点</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。<br>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * </ul>
 * </pre>
 * <p>
 * 示例 2：
 * <ul>
 * 
 * <pre>
 * 输入：head = []
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 示例 3：
 * <ul>
 * 
 * <pre>
 * 输入：head = [1]
 * 输出：[1]
 * </ul>
 * </pre>
 * <p>
 * 提示：
 * <ul>
 * <li>链表中节点的数目在范围 [0, 100] 内
 * <li>0 <= Node.val <= 100
 * </ul>
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 * <p>
 * 解法:
 * <p>
 * 设置虚拟头节点 dummy，pre 指针初始指向 dummy，遍历链表，每次交换 pre 后面的两个节点即可。
 * 
 * 
 * @author sichu
 * @date 2021/08/17
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;

        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            pre.next = tmp;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
