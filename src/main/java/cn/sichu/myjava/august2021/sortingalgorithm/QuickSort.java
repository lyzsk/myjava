package cn.sichu.myjava.august2021.sortingalgorithm;

import java.util.Arrays;

/**
 * 把原始的数组筛选成较小和较大的两个子数组， 然后递归地排序两个子数组。
 * 
 * @author sichu
 *
 */
public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        // 设定基准值
        int pivot = nums[i];

        while (i < j) {
            while (j > i && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            System.out.println("i>j " + Arrays.toString(nums));

            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
            System.out.println("i<j " + Arrays.toString(nums));
        }

        nums[i] = pivot;
        System.out.println("pivot: " + nums[i]);

        quickSort(nums, left, i - 1);
        quickSort(nums, j + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 2, 1, 5, 4, 3};
        quickSort(nums, 0, nums.length - 1);

    }
}
