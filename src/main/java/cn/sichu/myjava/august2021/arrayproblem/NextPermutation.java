package cn.sichu.myjava.august2021.arrayproblem;

/**
 * @see <a href = "https://leetcode-cn.com/problems/next-permutation/">31. 下一个排列</a>
 * @see <a href = "https://leetcode.com/problems/next-permutation/">31. Next Permutation</a>
 * @author sichu
 * @date 2022/03/18
 */
public class NextPermutation {
    /**
     * 1. 从数组最后一个元素开始扫描，找到 第一个 nums[i] > nums[i-1] 的 i
     * <p>
     * 2. 如果得到的 i >= 1， 说明存在下一个排列
     * <p>
     * 3.1 再从最后一个元素扫描， 寻找 第一个 nums[j] > nums[i - 1] 的 j
     * <p>
     * 由于 nums[i] > nums[i - 1], 所以得到的 j >= i
     * <p>
     * 3.2 交换索引为 i-1 和 j 的元素的值
     * <p>
     * 3.3 此时，索引 i-1 之后的元素, 必定是降序排列， 将其升序排列
     * <p>
     * Time Complexity: O(n), 最坏情况扫描2遍
     * <p>
     * Space Complexity: O(1)
     * 
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i >= 1) {
            int j = nums.length - 1;
            for (; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    break;
                }
            }
            swap(nums, i - 1, j);
            reverse(nums, i);
        } else {
            /**
             * 如果最大元素是 第0个元素，说明下一个排列是 字典排列的第一个元素，直接反转数组
             */
            reverse(nums, 0);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
