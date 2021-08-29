package cn.sichu.myjava.august2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. 最小栈 @see<a href = "https://leetcode-cn.com/problems/min-stack/">155. 最小栈</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <ul>
 * <li>push(x) —— 将元素 x 推入栈中。
 * <li>pop() —— 删除栈顶的元素。
 * <li>top() —— 获取栈顶元素。
 * <li>getMin() —— 检索栈中的最小元素。
 * </ul>
 * <strong>解法</strong>
 * <p>
 * “辅助栈”实现。
 * 
 * @author sichu
 * @date 2021/08/29
 */
public class MinStack {
    /**
     * <pre>
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     * </pre>
     */
    private Deque<Integer> datastack;
    private Deque<Integer> minstack;

    /* initialize your data structure here*/
    public MinStack() {
        datastack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
        // 没有这一行会NullPointerException
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        datastack.push(val);
        minstack.push(Math.min(minstack.peek(), val));
    }

    public void pop() {
        datastack.pop();
        minstack.pop();
    }

    public int top() {
        return datastack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
