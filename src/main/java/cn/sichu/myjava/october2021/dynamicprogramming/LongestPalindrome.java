package cn.sichu.myjava.october2021.dynamicprogramming;

/**
 * 5. 最长回文子串 @see<a href = "https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 提示：
 * <ul>
 * <li>1 <= s.length <= 1000
 * <li>s 仅由数字和英文字母（大写和/或小写）组成
 * </ul>
 * 解法
 * <p>
 * 设 dp[i][j] 表示字符串 s[i..j] 是否为回文串。
 * <ul>
 * <li>当 j - i < 2，即字符串长度为 2 时，只要 s[i] == s[j]，dp[i][j] 就为 true。
 * <li>当 j - i >= 2，dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]。
 * </ul>
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {

    }
}
