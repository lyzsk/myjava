package cn.sichu.myjava.august2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 59 - II. 队列的最大值 @see<a href = "https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/">面试题 59 - II.
 * 队列的最大值</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是 O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * <strong>解法</strong>
 * <p>
 * 利用一个辅助队列按单调顺序存储当前队列的最大值。
 * <p>
 * 本算法基于问题的一个重要性质：当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
 * <p>
 * 从队列尾部插入元素时，我们可以提前取出队列中所有比这个元素小的元素，使得队列中只保留对结果有影响的数字。这样的方法等价于要求维持队列单调递减，即要保证每个元素的前面都没有比它小的元素。
 * <p>
 * 
 * 
 * @author sichu
 * @date 2021/08/29
 */
public class MaxQueue {
    /**
     * <pre>
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     * </pre>
     */
    private Deque<Integer> p;
    private Deque<Integer> q;

    public MaxQueue() {
        p = new ArrayDeque<>();
        q = new ArrayDeque<>();
    }

    public int max_value() {
        return q.isEmpty() ? -1 : q.peek();
    }

    public void push_back(int value) {
        while (!q.isEmpty() && q.peekLast() < value) {
            q.pollLast();
        }
        p.offerLast(value);
        q.offerLast(value);

    }

    public int pop_front() {
        if (p.isEmpty()) {
            return -1;
        }
        int res = p.poll();
        if (q.peek() == res) {
            q.poll();
        }
        return res;
    }
}
