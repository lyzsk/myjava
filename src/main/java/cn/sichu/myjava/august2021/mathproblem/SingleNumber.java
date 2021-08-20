package cn.sichu.myjava.august2021.mathproblem;

/**
 * 136. 只出现一次的数字 @see<a href = "https://leetcode-cn.com/problems/single-number/">只出现一次的数字</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * <strong>解法</strong>
 * <p>
 * 异或运算求解。
 * <p>
 * 
 * 首先明确，两个相同的数异或之后的结果为 0。对该数组所有元素进行异或运算，结果就是那个只出现一次的数字。
 * 
 * @author sichu
 * @date 2021/08/20
 */
public class SingleNumber {
    /**
     * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次， 如果把所有的数都异或，相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身。
     * 
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
