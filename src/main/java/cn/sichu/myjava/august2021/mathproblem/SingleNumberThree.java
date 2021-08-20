package cn.sichu.myjava.august2021.mathproblem;

/**
 * 260. 只出现一次的数字 III @see<a href = "https://leetcode-cn.com/problems/single-number-iii/">只出现一次的数字III</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class SingleNumberThree {
    // TODO meidong :)
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        // 提取最右的 1
        int diff = eor & (~eor + 1);
        int a = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                a ^= num;
            }
        }
        int b = eor ^ a;
        return new int[] {a, b};
    }
}
