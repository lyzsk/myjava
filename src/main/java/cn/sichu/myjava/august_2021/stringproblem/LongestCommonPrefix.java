package cn.sichu.myjava.august_2021.stringproblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长公共前缀
 * <p>
 * 题目: <ul>编写一个函数来查找字符串数组中的最长公共前缀。<br>
 * 如果不存在公共前缀，返回空字符串 ""。
 * </ul><p>
 * 示例1:<br><ul>
 * 输入：strs = ["flower","flow","flight"]<br>
 * 输出："fl"</ul>
 * <p>
 * 示例2:<br><ul>
 * 输入：strs = ["dog","racecar","car"]<br>
 * 输出：""<br>
 * 解释：输入不存在公共前缀。</ul>
 * <p>
 * 提示:<br><ul>
 * "0 <= strs.length <= 200"<br>
 * "0 <= strs[i].length <= 200"<br>
 * strs[i] 仅由小写英文字母组成</ul>
 * <p>
 * 四种方法: 横向扫描，纵向扫描，分治法，二分查找
 * @author sichu
 *
 */
public class LongestCommonPrefix {
	
	/**
	 * 纵向扫描
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefixSolution1(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
    }
	
	/**
	 * 先排序，后比较头尾
	 * 还不如多加个 i >= strs[j].length()判断...
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefixSolution2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.stream(strs)
		.sorted(Comparator.comparingInt(String::length));
		
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != strs[0].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	/**
	 * 二分法
	 * 每次取查找范围的中间值 mid，
	 * 判断每个字符串的长度为 mid 的前缀是否相同,
	 * 如果相同则最长公共前缀的长度一定大于或等于 mid
	 * 如果不相同则最长公共前缀的长度一定小于 mid
	 * 
	 */
	public String longestCommonPrefixSolution3(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}
		
		int low = 0, high = minLength;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			if (isCommonPrefix(strs, mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		
		return strs[0].substring(0, low);
	}
	
	public boolean isCommonPrefix(String[] strs, int length) {
		String str0 = strs[0].substring(0, length);
		
		for (int i = 1; i < strs.length; i++) {
			for (int j = 0; j < length; j++) {
				if (str0.charAt(j) != strs[i].charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 分治法
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefixSolution4(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else {
			return longestCommonPrefixSolution4_(strs, 0, strs.length - 1);
		}
	}
	
	public String longestCommonPrefixSolution4_(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		} else {
			int mid = (end - start) / 2 + start;
			String lcpLeft = longestCommonPrefixSolution4_(strs, start, mid);
			String lcpRight = longestCommonPrefixSolution4_(strs, mid + 1, end);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}
	
	public String commonPrefix(String lcpLeft, String lcpRight) {
		int minLength = Math.min(lcpLeft.length(), lcpRight.length());
		for (int i = 0; i < minLength; i++) {
			if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
				return lcpLeft.substring(0, i);
			}
		}
		
		return lcpLeft.substring(0, minLength);
	}
}
