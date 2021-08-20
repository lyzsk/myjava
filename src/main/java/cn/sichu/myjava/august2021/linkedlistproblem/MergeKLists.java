package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 23. 合并K个升序链表 @see<a href = "https://leetcode-cn.com/problems/merge-k-sorted-lists">合并K个升序链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。<br>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *  1->4->5,
 *  1->3->4,
 *  2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * </ul>
 * </pre>
 * <p>
 * 示例 2：
 * <ul>
 * 
 * <pre>
 * 输入：lists = []
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 示例 3：
 * <ul>
 * 
 * <pre>
 * 输入：lists = [[]]
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 提示：
 * <ul>
 * <li>k == lists.length
 * <li>0 <= k <= 10^4
 * <li>0 <= lists[i].length <= 500
 * <li>-10^4 <= lists[i][j] <= 10^4
 * <li>lists[i] 按 升序 排列
 * <li>lists[i].length 的总和不超过 10^4
 * </ul>
 * <strong>解法</strong>
 * <p>
 * 合并前后两个链表，结果放在后一个链表位置上，依次循环下去。
 * 
 * @author sichu
 * @date 2021/08/17
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n;
        if (lists == null || (n = lists.length) == 0) {
            return null;
        }

        for (int i = 1; i < n; i++) {
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }
        return lists[n - 1];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
