package cn.sichu.myjava.august2021.linkedlistproblem;

/**
 * 707. 设计链表 @see<a href = "https://leetcode-cn.com/problems/design-linked-list/">707. 设计链表</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev
 * 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <ul>
 * <li>get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * <li>addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * <li>addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * <li>addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index
 * 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * <li>deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * </ul>
 * <strong>解法</strong>
 * <p>
 * 定义虚拟头结点 dummy，count 记录当前链表结点个数。
 * 
 * @author sichu
 * @date 2021/08/21
 */
public class MyLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode dummy;
    private int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummy = new ListNode(0);
        count = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        ListNode cur = dummy.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * <p>
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(count, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
     * be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > count) {
            return;
        }
        ListNode pre = dummy;
        while (index-- > 0) {
            pre = pre.next;
        }
        pre.next = new ListNode(val, pre.next);
        ++count;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) {
            return;
        }

        ListNode pre = dummy;
        while (index-- > 0) {
            pre = pre.next;
        }
        ListNode tmp = pre.next;
        pre.next = tmp.next;
        tmp.next = null;
        --count;
    }
}

/**
 * <pre>
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 * </pre>
 */