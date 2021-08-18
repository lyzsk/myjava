package cn.sichu.myjava.august2021.stringproblem;

/**反转字符串中的元音字母/vowel letter
 * <p>
 * 题目: <ul>编写一个函数，以字符串作为输入，反转该字符串中的元音字母。</ul>
 * <p>
 * eg1: <br><ul>
 * 输入："hello"<br>
 * 输出："holle"</ul>
 * <p>
 * eg2.<br><ul>
 * 输入："leetcode"<br>
 * 输出："leotcede"</ul>
 * <p>
 * HINT:
 * 元音字母不包含字母 "y" 。
 * <p>
 * 解法:<br><ul>
 * 将字符串转为字符数组（或列表），定义双指针 i、j，<br>
 * 分别指向数组（列表）头部和尾部，<br>
 * 当 i、j 指向的字符均为元音字母时，进行交换。></ul>
 * 
 * @author sichu
 *
 */
public class ReverseVowels {
	public boolean isVowel(char c) {
		return c == 'a' || c == 'A' ||
			   c == 'e' || c == 'E' ||
			   c == 'i' || c == 'I' ||
			   c == 'o' || c == 'O' ||
			   c == 'u' || c == 'U';
	}
	
	
	public String reverseVowels(String s) {
		int left = 0, right = s.length() - 1;
		char[] charArray = s.toCharArray();
		
		while (left < right) {
			if (!isVowel(charArray[left])) {
				left++;
			} else if (!isVowel(charArray[right])) {
				right--;
			} else {
				char tmp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = tmp;
				left++;
				right--;
			}
		}
		String res = new String(charArray);
		return res;
	}
	
}
