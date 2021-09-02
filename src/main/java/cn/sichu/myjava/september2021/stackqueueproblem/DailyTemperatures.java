package cn.sichu.myjava.september2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度 @see<a href = "https://leetcode-cn.com/problems/daily-temperatures/">739. 每日温度</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 栈实现，栈存放 T 中元素的的下标 i，结果用数组 res 存储。
 * <p>
 * 遍历 T，遍历到 T[i] 时：
 * <ul>
 * <li>若栈不为空，并且栈顶元素小于 T[i] 时，弹出栈顶元素 j，并且 res[j] 赋值为 i - j。
 * <li>然后将 i 压入栈中。
 * </ul>
 * 最后返回结果数组 res 即可。
 * 
 * @author sichu
 * @date 2021/09/01
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int j = s.pop();
                res[j] = i - j;
            }
            s.push(i);
        }
        return res;
    }
}
