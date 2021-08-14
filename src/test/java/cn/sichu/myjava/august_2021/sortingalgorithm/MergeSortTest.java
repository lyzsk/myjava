package cn.sichu.myjava.august_2021.sortingalgorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSortTest {
	MergeSort sort;
	int[] input1;
	int[] expect1;
	
	@BeforeEach
	void setUp() throws Exception {
		this.sort = new MergeSort();
		this.input1 = new int[] {2, 4, 1, 6, 8, 5, 3, 7};
		this.expect1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
	}

	@AfterEach
	void tearDown() throws Exception {
		this.sort = null;
		this.input1 = null;
		this.expect1 = null;
	}

	@Test
	void testMergeSort() {
		assertArrayEquals(expect1, sort.mergeSort(input1));
	}

}
