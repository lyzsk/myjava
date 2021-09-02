package cn.sichu.myjava.september2021.stackqueueproblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I @see<a href = "https://leetcode-cn.com/problems/next-greater-element-i/">496. 下一个更大元素 I</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 * <p>
 * 解法
 * <p>
 * 先对将 nums2 中的每一个元素，求出其下一个更大的元素。随后对于将这些答案放入哈希映射（HashMap）中，再遍历数组 nums1，并直接找出答案。对于 nums2，可以使用单调栈来解决这个问题。
 * 
 * @author sichu
 * @date 2021/09/02
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
