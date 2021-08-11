package cn.sichu.myjava.august_2021.stringproblem;

/**
 * 题目:<ul>
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。<br>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。
 * </ul><p>
 * 示例 1：<ul>
 * 输入：ransomNote = "a", magazine = "b"<br>
 * 输出：false
 * </ul><p>
 * 示例 2：<ul>
 * 输入：ransomNote = "aa", magazine = "ab"<br>
 * 输出：false
 * </ul><p>
 * 示例 3：<ul>
 * 输入：ransomNote = "aa", magazine = "aab"<br>
 * 输出：true
 * </ul>
 * 提示:<ul>
 * 你可以假设两个字符串均只含有小写字母。
 * </ul><p>
 * 解法:<ul>
 * 用一个数组或字典 chars 存放 magazine 中每个字母出现的次数。
 * 遍历 ransomNote 中每个字母，判断 chars 是否包含即可。
 * </ul>
 * @author sichu
 *
 */
public class CanConstruct {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] chars = new int[26];
		
		for (int i = 0, n = magazine.length(); i < n; i++) {
			int idx = magazine.charAt(i) - 'a';
			chars[idx]++;
		}
		
		for (int i = 0, n = ransomNote.length(); i < n; i++) {
			int idx = ransomNote.charAt(i) - 'a';
			if (chars[idx] == 0) {
				return false;
			}
			chars[idx]--;
		}
		return true;
    }
}
