package cn.sichu.myjava.august_2021.sortingalgorithm;

/**
 * 定义一个布尔变量 hasChange，用来标记每轮是否进行了交换。<br>
 * 在每轮遍历开始时，将 hasChange 设置为 false。<br>
 * 若当轮没有发生交换，说明此时数组已经按照升序排列，<br>
 * hashChange 依然是为 false。此时外层循环直接退出，排序结束。
 * @author sichu
 *
 */
public class BubbleSort {
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public int[] bubbleSort(int[] nums) {
		boolean hasChange = true;
		for (int i = 0; i < nums.length - 1 && hasChange; i++) {
			hasChange = false;
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
					hasChange = true;
				}
			}
		}
		return nums;
	}
}
