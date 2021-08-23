package cn.sichu.myjava.august2021.mathproblem;

import java.util.Arrays;

/**
 * 204. 计数质数 @see<a href = "https://leetcode-cn.com/problems/count-primes/">计数质数</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数，因此我们可以从这里入手。
 * <p>
 * 我们设 primes[i] 表示数 i 是不是质数，如果是质数则为 true，否则为 false。从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即
 * false，这样在运行结束的时候我们即能知道质数的个数。
 * <p>
 * 对于一个质数 x，我们从 2x 开始标记其实是冗余的，应该直接从 x⋅x 开始标记，因为 2x,3x,… 这些数一定在 x 之前就被其他数的倍数标记过了，例如 2 的所有倍数，3 的所有倍数等。
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                ++res;
            }
            if ((long)i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return res;
    }
}
