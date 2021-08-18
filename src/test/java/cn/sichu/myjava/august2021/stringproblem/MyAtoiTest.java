package cn.sichu.myjava.august2021.stringproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyAtoiTest {
    MyAtoi atoi;
    String s1, s2, s3, s4, s5;
    Integer res1, res2, res3, res4, res5;

    @BeforeEach
    void setUp() throws Exception {
        this.atoi = new MyAtoi();
        this.s1 = "42";
        this.s2 = "   -42";
        this.s3 = "4193 with words";
        this.s4 = "words and 987";
        this.s5 = "-91283472332";
        this.res1 = 42;
        this.res2 = -42;
        this.res3 = 4193;
        this.res4 = 0;
        this.res5 = -2147483648;
    }

    @AfterEach
    void tearDown() throws Exception {
        this.atoi = null;
        this.s1 = null;
        this.s2 = null;
        this.s3 = null;
        this.s4 = null;
        this.s5 = null;
        this.res1 = null;
        this.res2 = null;
        this.res3 = null;
        this.res4 = null;
        this.res5 = null;
    }

    @Test
    void testMyAtoi() {
        assertEquals(res1, atoi.myAtoi(s1));
        assertEquals(res2, atoi.myAtoi(s2));
        assertEquals(res3, atoi.myAtoi(s3));
        assertEquals(res4, atoi.myAtoi(s4));
        assertEquals(res5, atoi.myAtoi(s5));
    }

}
