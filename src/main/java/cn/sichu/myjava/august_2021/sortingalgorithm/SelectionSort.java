package cn.sichu.myjava.august_2021.sortingalgorithm;

import java.util.Arrays;

/**
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，
 * 将其放到已排序区间的末尾。
 * @author sichu
 *
 */
public class SelectionSort {
	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			int tmp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 7, 8, 5};
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
