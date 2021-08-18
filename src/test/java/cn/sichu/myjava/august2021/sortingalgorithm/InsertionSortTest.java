package cn.sichu.myjava.august2021.sortingalgorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionSortTest {
    InsertionSort sort;
    int[] nums1;
    int[] result1;

    @BeforeEach
    void setUp() throws Exception {
        this.sort = new InsertionSort();
        this.nums1 = new int[] {1, 2, 7, 9, 5, 8};
        this.result1 = new int[] {1, 2, 5, 7, 8, 9};
    }

    @AfterEach
    void tearDown() throws Exception {
        this.sort = null;
        this.nums1 = null;
        this.result1 = null;
    }

    @Test
    void testInsertionSortTest() {
        assertArrayEquals(result1, sort.insertionSort(nums1));
    }

}
