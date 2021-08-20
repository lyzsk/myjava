package cn.sichu.myjava.august2021.mathproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleNumberTest {
    SingleNumber sn;
    int[] nums;

    @BeforeEach
    void setUp() throws Exception {
        this.sn = new SingleNumber();
        this.nums = new int[] {10, 11, 2, 0, 7, 11, 10, 2, 0};
    }

    @AfterEach
    void tearDown() throws Exception {
        this.sn = null;
        this.nums = null;
    }

    @Test
    void testSingleNumber() {
        assertEquals(7, sn.singleNumber(nums));
    }

}
