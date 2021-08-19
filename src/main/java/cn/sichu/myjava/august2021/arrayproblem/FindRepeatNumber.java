package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 数组中重复的数字 @see<a href = "https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">数组中重复的数字</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1 的范围内。 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * <strong>限制：</strong>
 * <p>
 * 2 <= n <= 100000
 * <p>
 * <strong>解法</strong>
 * <p>
 * 0 ～ n-1 范围内的数，分别还原到对应的位置上，如：数字 2 交换到下标为 2 的位置。
 * <p>
 * 若交换过程中发现重复，则直接返回。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class FindRepeatNumber {
    /**
     * 
     * 
     * @param nums
     * @return
     */
    // TODO 看不懂
    public int findRepeatNumber(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 因为 <strong><u>在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1 的范围内。</u></strong>
     * <p>
     * 假设第 i 个位置对应的数值为 num ，先修改当 num 为下标时候的值为负数，如果有重复，那么再次修改这个 num 为下标的数值时就是负数，这个时候就返回num就可以了。
     * 
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num < 0) {
                num += len;
            }
            if (nums[num] < 0) {
                return num;
            }
            nums[num] -= len;
        }
        return -1;
    }
}
