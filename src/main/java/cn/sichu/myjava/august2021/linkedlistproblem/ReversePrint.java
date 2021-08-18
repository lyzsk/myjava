package cn.sichu.myjava.august2021.linkedlistproblem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目描述:
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <ul>
 * 
 * <pre>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * </ul>
 * </pre>
 * 
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 解法:
 * <p>
 * 栈实现。<br>
 * 或者先计算链表长度 n，然后创建一个长度为 n 的结果数组。最后遍历链表，依次将节点值存放在数组上（从后往前）。
 * 
 * @author sichu
 *
 */
public class ReversePrint {

    /**
     * use stack
     * 
     * @param head
     * @return res
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }

        int[] res = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            res[i++] = deque.pop();
        }

        return res;
    }

    /**
     * 先计算链表长度 n，然后创建一个长度为 n 的结果数组。 最后遍历链表，依次将节点值存放在数组上（从后往前）。
     * 
     * @param head
     * @return res
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[] {};
        }

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }

        int[] res = new int[len];
        cur = head;
        while (cur != null) {
            res[--len] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
