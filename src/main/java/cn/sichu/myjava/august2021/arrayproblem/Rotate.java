package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 189. 旋转数组 @see<a href = "https://leetcode-cn.com/problems/rotate-array">旋转数组</a>
 * <p>
 * <strong>题目描述<strong>
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * <strong>进阶：<strong>
 * <ul>
 * <li>尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * <li>你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * </ul>
 * <strong>解法</strong>
 * <p>
 * 若 k=3，nums=[1,2,3,4,5,6,7]。
 * <p>
 * 先将 nums 整体翻转：[1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
 * <p>
 * 再翻转 0~k-1 范围内的元素：[7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
 * <p>
 * 最后翻转 k~n-1 范围内的元素，即可得到最终结果：[5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        k %= len;
        if (len < 2 || k == 0) {
            return;
        }
        rotate(nums, 0, len - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, len - 1);
    }

    private void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
    }
}
