package cn.sichu.myjava.september2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 503. 下一个更大元素 II @see<a href = "https://leetcode-cn.com/problems/next-greater-element-ii/">503. 下一个更大元素 II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x
 * 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * <strong>解法</strong>
 * <p>
 * “单调栈 + 循环数组”实现。
 * 
 * @author sichu
 * @date 2021/09/02
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < (n << 1); i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
