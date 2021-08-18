package cn.sichu.myjava.august2021.sortingalgorithm;

import java.util.Arrays;

/**
 * 把数组从中间划分为两个子数组，一直递归地把子数组划分成更小的数组， 直到子数组里面只有一个元素的时候开始排序。<br>
 * 按照大小顺序合并两个元素，接着依次按照递归的顺序返回， 不断合并排好序的数组，直到把整个数组排好序。
 * 
 * @author sichu
 *
 */
public class MergeSort {

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
