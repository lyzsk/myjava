package cn.sichu.myjava.october2021.dynamicprogramming;

/**
 * 1143. 最长公共子序列 @see<a href = "https://leetcode-cn.com/problems/longest-common-subsequence/">1143. 最长公共子序列</a>
 * <p>
 * 题目描述
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <ul>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * </ul>
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 提示：
 * <ul>
 * <li>1 <= text1.length, text2.length <= 1000
 * <li>text1 和 text2 仅由小写英文字符组成。
 * </ul>
 * 解法
 * <p>
 * 定义 dp[i][j] 表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列（闭区间）。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

    }
}
