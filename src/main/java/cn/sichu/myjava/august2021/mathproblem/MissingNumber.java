package cn.sichu.myjava.august2021.mathproblem;

/**
 * 268. 丢失的数字 @see<a href = "https://leetcode-cn.com/problems/missing-number/">268. 丢失的数字</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * <strong>进阶：</strong>
 * <p>
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * <p>
 * <strong>解法</strong>
 * <p>
 * 异或求解。两个相同的数异或的结果为 0。
 * <p>
 * 也可以用数学求解。求出 [0..n] 的和，减去数组中所有数的和，就得到了缺失的数字。
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0, n = res; i < n; i++) {
            System.out.println("i = " + i + "|| res = " + res + "||(i ^ nums[i]) = " + (i ^ nums[i]));
            res ^= (i ^ nums[i]);
            System.out.println("||res ^= " + res);

        }
        return res;
    }

}
