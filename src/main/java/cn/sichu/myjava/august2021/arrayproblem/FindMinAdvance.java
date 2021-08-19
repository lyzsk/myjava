package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 寻找旋转排序数组中的最小值II @see<a href =
 * "https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii">寻找旋转排序数组中的最小值 II</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * <ul>
 * <li>若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * <li>若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * </ul>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 二分法。
 * <p>
 * 若 nums[m] > nums[r]，说明最小值在 m 的右边；若 nums[m] < nums[r]，说明最小值在 m 的左边（包括 m）；若相等，无法判断，直接将 r 减 1。循环比较。
 * <p>
 * 最后返回 nums[l] 即可。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class FindMinAdvance {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                --r;
            }
        }
        return nums[l];
    }
}
