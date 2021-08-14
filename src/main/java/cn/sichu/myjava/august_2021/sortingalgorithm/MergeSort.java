package cn.sichu.myjava.august_2021.sortingalgorithm;

import java.util.Arrays;

/**
 * 把数组从中间划分为两个子数组，一直递归地把子数组划分成更小的数组，
 * 直到子数组里面只有一个元素的时候开始排序。<br>
 * 按照大小顺序合并两个元素，接着依次按照递归的顺序返回，
 * 不断合并排好序的数组，直到把整个数组排好序。
 * @author sichu
 *
 */
public class MergeSort {
//	public void mergeSort(int[] nums, int start, int end) {
//		if (start >= end) {
//			return;
//		}
//		
//		int mid = (start + end) >> 1;
//		mergeSort(nums, start, mid);
//		mergeSort(nums, mid + 1, end);
//		int i = start, j = mid + 1, k = 0;
//		int[] tmp = {};
//		while (i <= mid && j <= end) {
//			if (nums[i] <= nums[j]) {
//				tmp[k++] = nums[i++];
//			} else {
//				tmp[k++] = nums[j++];
//			}
//		}
//		
//		while (i <= mid) {
//			tmp[k++] = nums[i++];
//		}
//		while (j <= end) {
//			tmp[k++] = nums[j++];
//		}
//		for (i = start, j = 0; i <= end; i++, j++) {
//			nums[i] = tmp[j];
//		}
//		
//	}
	
	public int[] mergeSort(int[] input) {
		if (input.length < 2) {
			return input;
		}
		int mid = input.length >> 1;
		int[] left = Arrays.copyOfRange(input, 0, mid);
		int[] right = Arrays.copyOfRange(input, mid, input.length);
		
		return merge(mergeSort(left), mergeSort(right));
	}
	
	public int[] merge(int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		int[] output = new int[left.length + right.length];
	
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				output[k++] = left[i++];
			} else {
				output[k++] = right[j++];
			}
		}
		while (i < left.length) {
			output[k++] = left[i++];
		}
		while (j < right.length) {
			output[k++] = right[j++];
		}
		return output;
	}
}
