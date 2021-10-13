package cn.sichu.myjava.october2021.dynamicprogramming;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题 @see<a href = "https://leetcode-cn.com/problems/russian-doll-envelopes/">354. 俄罗斯套娃信封问题</a>
 * <p>
 * 题目描述
 * <p>
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * 提示：
 * <ul>
 * <li>1 <= envelopes.length <= 5000
 * <li>envelopes[i].length == 2
 * <li>1 <= wi, hi <= 10<sup>4</sup>
 * </ul>
 * 解法
 * <p>
 * 排序 + 最长递增子序列。
 * <p>
 * 按 w 进行升序排序，若 w 相同则按 h 降序排序。然后问题转换为求 h 数组的最长递增子序列长度。
 * 
 * @author sichu
 * @date 2021/10/03
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n;
        if (envelopes == null || (n = envelopes.length) == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        return 0;
    }
}
