package cn.sichu.myjava.september2021.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目描述
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <ul>
 * <li>拆分时可以重复使用字典中的单词。
 * <li>你可以假设字典中没有重复的单词。
 * </ul>
 * 解法
 * <p>
 * dp[i] 表示前 i 个字符组成的字符串 s[0...i-1] 能否拆分成若干个字典中出现的单词。
 * 
 * @author sichu
 * @date 2021/09/22
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
