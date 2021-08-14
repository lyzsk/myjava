package cn.sichu.myjava.august_2021.sortingalgorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
	BubbleSort bubbleSort;
	int[] nums1;
	int[] result1;
	@BeforeEach
	void setUp() throws Exception {
		this.bubbleSort = new BubbleSort();
		this.nums1 = new int[] {1, 2, 7, 9, 5, 8};
		this.result1 = new int[] {1, 2, 5, 7, 8, 9};
	}

	@AfterEach
	void tearDown() throws Exception {
		this.bubbleSort = null;
		this.nums1 = null;
		this.result1 = null;
	}

	@Test
	void testBubbleSort() {
		assertArrayEquals(result1, bubbleSort.bubbleSort(nums1));
	}

}
