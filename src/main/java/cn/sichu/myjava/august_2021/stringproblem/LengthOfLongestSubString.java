package cn.sichu.myjava.august_2021.stringproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * <p>
 * 题目: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例1：<br>
 * 输入: "abcabcbb"<br>
 * 输出: 3<br>
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。<br>
 * <p>
 * 示例2:<br>
 * 输入: "bbbbb"<br>
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。<br>
 * <p>
 * 示例3:<br>
 * 输入: "pwwkew"<br>
 * 输出: 3<br>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。<br>
 * 注意: 你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 实例4:<br>
 * 输入: s = ""<br>
 * 输出: 0
 * <p>
 * 提示:<br>
 * "0 <= s.length <= 5 * 10^4"<br>
 * s 由英文字母、数字、符号和空格组成<br>
 * <p>
 * 解法:<br>
 * 定义一个哈希表存放字符及其出现的位置；<br>
 * 定义 start, end 分别表示不重复子串的开始位置和结束位置；<br>
 * end 向后遍历，若遇到与 [start, end] 区间内字符相同的元素，更新 start 的值，此时 [start, end] 区间内不存在重复字符，计算 res 的最大值。<br>
 * <p>
 * TODO: 啥是滑动窗口？？？？
 * @author sichu
 *
 */
public class LengthOfLongestSubString {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() > 5 * Math.pow(10, 4) || s.length() < 0) {
			throw new IllegalArgumentException();
		}
		
		int res = 0;
		Map<Character, Integer> charmap = new HashMap<>();
		
		for (int start = 0, end = 0; end < s.length(); end ++) {
			char c = s.charAt(end);
			
			if (charmap.containsKey(c)) {
				start = Math.max(start, charmap.get(c) + 1);
			}
			
			charmap.put(c, end);
			res = Math.max(res, end - start + 1);
		}
		return res;
    }
}
