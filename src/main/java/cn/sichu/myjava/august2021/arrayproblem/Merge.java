package cn.sichu.myjava.august2021.arrayproblem;

/**
 * 合并两个有序数组 @see<a href = "https://leetcode-cn.com/problems/merge-sorted-array">合并两个有序数组</a>
 * <p>
 * <strong>题目描述</strong>
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <strong>解法</strong>
 * <p>
 * 双指针解决。
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
