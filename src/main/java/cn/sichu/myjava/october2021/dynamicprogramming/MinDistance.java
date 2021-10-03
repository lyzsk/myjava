package cn.sichu.myjava.october2021.dynamicprogramming;

/**
 * 72. 编辑距离 @see<a href = "https://leetcode-cn.com/problems/edit-distance/">72. 编辑距离</a>
 * <p>
 * 题目描述
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * <ul>
 * <li>插入一个字符
 * <li>删除一个字符
 * <li>替换一个字符
 * </ul>
 * 提示：
 * <ul>
 * <li>0 <= word1.length, word2.length <= 500
 * <li>word1 和 word2 由小写英文字母组成
 * </ul>
 * 解法
 * <p>
 * 设 dp[i][j] 表示将 word1 前 i 个字符组成的字符串 word1[0...i-1] 转换成 word2 前 j 个字符组成的字符串 word2[0...j-1] 的最小操作次数。
 * <p>
 * 初始化 dp[i][0] = i（i∈[0, word1.length]），dp[0][j] = j （j∈[0, word2.length]）。
 * <p>
 * i, j 分别从 1 开始遍历，判断 word1[i - 1] 与 word2[j - 1] 是否相等：
 * <ul>
 * <li>若 word1[i - 1] == word2[j - 1]，dp[i][j] = dp[i - 1][j - 1]。
 * <li>若 word1[i - 1] != word2[j - 1]，dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1。其中 dp[i - 1][j] +
 * 1 对应插入操作，dp[i][j - 1] + 1 对应删除操作，dp[i - 1][j - 1] + 1 对应替换操作。取三者的最小值即可。
 * </ul>
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {

    }
}
