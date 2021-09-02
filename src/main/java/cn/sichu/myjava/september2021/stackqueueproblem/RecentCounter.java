package cn.sichu.myjava.september2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 933. 最近的请求次数 <a href = "https://leetcode-cn.com/problems/number-of-recent-calls/">933. 最近的请求次数</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * <p>
 * 请你实现 RecentCounter 类：
 * <ul>
 * <li>RecentCounter() 初始化计数器，请求数为 0 。
 * <li>int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * </ul>
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 * <strong>解法</strong><pp> 在第 1、100、3001、3002 这四个时间点分别进行了 ping 请求， 在 3001 秒的时候， 它前面的 3000 秒指的是区间 [1,3001]， 所以一共是有
 * 1、100、3001 三个请求， t = 3002 的前 3000 秒指的是区间 [2,3002], 所以有 100、3001、3002 三次请求。
 * <p>
 * 可以用队列实现。每次将 t 进入队尾，同时从队头开始依次移除小于 t-3000 的元素。然后返回队列的大小 q.size() 即可。
 * 
 * @author sichu
 * @date 2021/09/01
 */
public class RecentCounter {
    /**
     * <pre>
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     * </pre>
     */
    private Deque<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
