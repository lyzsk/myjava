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
        int len = s.length();
        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int maxlen = 1;

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (j - i < 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                // 只要 dp[i][j] == true 成立， 就表示 子串为回文， 记录 起始位置 和 回文长度
                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    // TODO: 下面这个快，但是没懂.

    // public String longestPalindrome(String s) {
    // if (s == null || s.length() == 0) {
    // return "";
    // }
    //
    // // 保存起始位置， 用数组比全局变量快
    // int[] range = new int[2];
    // char[] str = s.toCharArray();
    //
    // for (int i = 0; i < s.length(); i++) {
    // // 把回文看成中间部分全是同一字符，左右部分对称
    // // 找到下一个与当前字符不同的字符
    // i = findLogest(str, i, range);
    // }
    // return s.substring(range[0], range[1] + 1);
    // }
    //
    // public static int findLogest(char[] str, int low, int[] range) {
    // // 查找中间部分
    // int high = low;
    // while (high < str.length - 1 && str[high + 1] == str[low]) {
    // high++;
    // }
    //
    // // 定位中间部分最后一个字符
    // int ans = high;
    //
    // // 从中间向左右扩散
    // while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
    // low--;
    // high++;
    // }
    //
    // // 记录最大长度
    // if (high - low > range[1] - range[0]) {
    // range[0] = low;
    // range[1] = high;
    // }
    //
    // return ans;
    // }
}
