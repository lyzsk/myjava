package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 70. 爬楼梯 @see<a href = "https://leetcode-cn.com/problems/climbing-stairs/">70. 爬楼梯</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 假设你正在爬楼梯。需要 <em>n</em> 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 想上第 n 级台阶，可从第 n-1 级台阶爬一级上去，也可从第 n-2 级台阶爬两级上去，即：f(n) = f(n-1) + f(n-2)。递推求解即可。
 * 
 * @author sichu
 * @date 2021/09/04
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
