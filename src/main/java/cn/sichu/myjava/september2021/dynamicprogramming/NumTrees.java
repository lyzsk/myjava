package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 96. 不同的二叉搜索树 @see<a href = "https://leetcode-cn.com/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 * <p>
 * 题目描述
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 假设 n 个节点存在二叉搜索树的个数是 G(n)，1 为根节点，2 为根节点，...，n 为根节点，当 1 为根节点时，其左子树节点个数为 0，右子树节点个数为 n-1，同理当 2 为根节点时，其左子树节点个数为 1，右子树节点为
 * n-2，所以可得 G(n) = G(0) * G(n-1) + G(1) * (n-2) + ... + G(n-1) * G(0)。
 * 
 * @author sichu
 * @date 2021/09/27
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
