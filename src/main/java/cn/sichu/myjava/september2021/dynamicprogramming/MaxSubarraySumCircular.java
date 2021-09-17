package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 918. 环形子数组的最大和 @see<a href = "https://leetcode-cn.com/problems/maximum-sum-circular-subarray/">918. 环形子数组的最大和</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个由整数数组 <code>A</code> 表示的环形数组 <code>C</code>，求 <code>C</code> 的非空子数组的最大可能和。
 * <p>
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当 <code>0 <= i < A.length</code> 时 <code>C[i] = A[i]</code>，且当 <code>i >= 0</code> 时
 * <code>C[i+A.length] = C[i]）</code>
 * <p>
 * 此外，子数组最多只能包含固定缓冲区 <code>A</code> 中的每个元素一次。（形式上，对于子数组 <code>C[i], C[i+1], ..., C[j]</code>，不存在
 * <code>i <= k1, k2 <= j</code> 其中 <code>k1 % A.length = k2 % A.length</code>）
 * <p>
 * <strong>解法</strong>
 * <p>
 * Kadane 算法基于动态规划。令 dp[j] 为以 A[j] 结尾的最大子段和。也就是，
 * 
 * <pre>
 *              dp[j] = max(A[i] + A[i+1]+...+A[j])
 * </pre>
 * 
 * 有以下递推式：
 * 
 * <pre>
 * dp[j + 1] = A[j + 1] + max(dp[j], 0)
 * </pre>
 * 
 * 由于一个子段一定从某个位置截止，所以 <code>max dp[j]</code> 就是需要的答案。 为了计算 dp 数组更快，Kadane 算法通常节约空间复杂度的形式表示。我们只维护两个变量 ans 等于
 * <code>max dp[j]</code> 和 cur 等于 dp[j] 。随着 j 从 00 到 A.\text{length}-1A.length−1 遍历。
 * <p>
 * 循环数组的子段可以被分成 单区间 子段或者 双区间 子段，取决于定长数组 A 需要多少区间去表示。
 * <p>
 * 例如，如果 A = [0, 1, 2, 3, 4, 5, 6] 是给定的循环数组，我们可以表示子段 [2, 3, 4] 为单区间 [2, 4][2,4]；如果我们希望表示子段 [5, 6, 0, 1]，那就是双区间 [5, 6],
 * [0, 1][5,6],[0,1]。
 * <p>
 * 使用 Kadane 算法，我们知道如何计算一个单区间子段的最大值，所以剩下的问题是双区间子段。
 * <p>
 * 
 * @author sichu
 * @date 2021/09/17
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int dp = nums[0], max = dp, sum = dp, min = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
        }
        dp = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp = nums[i] + Math.min(0, dp);
            min = Math.min(dp, min);
        }
        return Math.max(sum - min, max);

    }
}
