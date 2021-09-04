package cn.sichu.myjava.september2021.dynamicprogramming;

/**
 * 1137. 第 N 个泰波那契数 @see<a href = "https://leetcode-cn.com/problems/n-th-tribonacci-number/">1137. 第 N 个泰波那契数</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, 且在 n >= 0 的条件下 T<sub>n+3</sub> = T<sub>n</usb> +
 * T<sub>n+1</sub> + T<sub>n+2</sub>
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 T<sub>n</sub> 的值。
 * <p>
 * 
 * 
 * 
 * @author sichu
 * @date 2021/09/04
 */
public class Tribonacci {
    public int tribonacci(int n) {

        int a = 0;
        int b = 1;
        int c = 1;
        while (n-- > 0) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        return a;
    }
}
