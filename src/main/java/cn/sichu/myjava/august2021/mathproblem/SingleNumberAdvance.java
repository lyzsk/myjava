package cn.sichu.myjava.august2021.mathproblem;

/**
 * 137. 只出现一次的数字 II @see<a href = "https://leetcode-cn.com/problems/single-number-ii/">只出现一次的数字II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 统计所有数字每个位中 1 出现的次数，对于某个位，1 出现的次数一定是 3 的倍数 +1 或 0。对这个数 %3 得到的结果就是那个出现一次的数字在该位上的值。
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class SingleNumberAdvance {
    // TODO meidong
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num & 1);
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 == 1) {
                res |= (1 << i);
            }
        }

        return res;
    }
}
