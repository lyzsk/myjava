package cn.sichu.myjava.august2021.mathproblem;

/**
 * 645. 错误的集合 @see<a href = "https://leetcode-cn.com/problems/set-mismatch/">错误的集合</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 异或运算求解。
 * <p>
 * 首先明确，两个相同的数异或之后的结果为 0。对该数组所有元素以及 i∈[1, n] 所有数字进行异或运算，结果就是两个只出现一次的数字异或的结果，即 eor = a ^ b。
 * <p>
 * 找出这个结果 eor 中最后一个二进制位为 1 而其余位为 0 的数，即 eor & (~eor + 1)，之后遍历数组所有元素以及 i∈[1, n] 所有数字，二进制位为 0 的元素异或到 a。
 * <p>
 * 遍历结束后 b = eor ^ a，返回结果即可。
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int eor = 0;
        for (int i = 1; i <= nums.length; ++i) {
            eor ^= (i ^ nums[i - 1]);
        }
        int diff = eor & (~eor + 1);
        int a = 0;
        for (int i = 1; i <= nums.length; ++i) {
            if ((nums[i - 1] & diff) == 0) {
                a ^= nums[i - 1];
            }
            if ((i & diff) == 0) {
                a ^= i;
            }
        }
        int b = eor ^ a;
        for (int num : nums) {
            if (a == num) {
                return new int[] {a, b};
            }
        }
        return new int[] {b, a};
    }
}
