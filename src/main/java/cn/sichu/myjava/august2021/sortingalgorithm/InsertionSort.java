package cn.sichu.myjava.august2021.sortingalgorithm;

/**
 * 在冒泡排序中，经过每一轮的排序处理后，数组后端的数是排好序的。<br>
 * 在插入排序中，经过每一轮的排序处理后，数组前端的数是排好序的。
 * 
 * @author sichu
 *
 */
public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        for (int i = 1, j = nums.length; i < nums.length; i++) {
            int num = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > num; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
        return nums;
    }

}
