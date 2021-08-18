package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 排序链表 @see<a href = "https://leetcode-cn.com/problems/sort-list">排序链表</a>
 * 
 * <p>
 * 题目描述:
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <ul>
 * <li>你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * </ul>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * </ul>
 * </pre>
 * <p>
 * 示例 2：
 * <ul>
 * 
 * <pre>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * </ul>
 * </pre>
 * <p>
 * 示例 3：
 * <ul>
 * 
 * <pre>
 * 输入：head = []
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 提示：
 * <ul>
 * <li>链表中节点的数目在范围 [0, 5 * 10<sup>4</sup>] 内
 * <li>-10<sup>5</sup> <= Node.val <= 10<sup>5</sup>
 * </ul>
 * <p>
 * 解法:
 * <p>
 * 先用快慢指针找到链表中点，然后分成左右两个链表，递归排序左右链表。最后合并两个排序的链表即可。
 * 
 * @author sichu
 * @date 2021/08/18
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(tmp);

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
