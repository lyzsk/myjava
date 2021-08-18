package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 题目描述:
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * </ul>
 * </pre>
 * <p>
 * 示例 2：
 * <ul>
 * 
 * <pre>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * </ul>
 * </pre>
 * <p>
 * 示例 3：
 * <ul>
 * 
 * <pre>
 * 输入：l1 = [], l2 = [0]
 * </ul>
 * </pre>
 * <p>
 * 输出：[0]
 * <p>
 * 提示：
 * <ul>
 * <li>两个链表的节点数目范围是 [0, 50]
 * <li>-100 <= Node.val <= 100
 * <li>l1 和 l2 均按 非递减顺序 排列
 * </ul>
 * 解法
 * <p>
 * 迭代遍历两链表，比较节点值 val 的大小，进行节点串联，得到最终链表。
 * 
 * @author sichu
 * @date 2021/08/17
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
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
