package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 413. 等差数列划分 @see<a herf = "https://leetcode-cn.com/problems/arithmetic-slices/">413. 等差数列划分</a>
 * <p>
 * 题目描述
 * <p>
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * 
 * <pre>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * </pre>
 * 
 * 以下数列不是等差数列。
 * 
 * <pre>
 * 1, 1, 2, 5, 7
 * </pre>
 * 
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 * 解法
 * <p>
 * 设 dp[i] 表示以 i 结尾的数组构成的等差数列的个数。
 * <p>
 * 如果 nums[i] + nums[i - 2] ≠ nums[i - 1] * 2，说明以 i 结尾的数组无法构成等差数列，dp[i] = 0；否则 dp[i] = 1 + dp[i - 1]。
 * <p>
 * 结果返回 dp 数组所有元素之和即可。
 * 
 * @author sichu
 * @date 2021/09/27
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] + nums[i - 2] == (nums[i - 1] << 1)) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = 0;
        for (int element : dp) {
            res += element;
        }
        return res;
    }

}
