package cn.sichu.myjava.august2021.stringproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {
    LongestCommonPrefix q;
    String[] s1, s2, s3, s4;

    @BeforeEach
    void setUp() throws Exception {
        this.q = new LongestCommonPrefix();
        this.s1 = new String[] {"flower", "flow", "flight"};
        this.s2 = new String[] {"dog", "racecar", "car"};
        this.s3 = new String[] {""};
    }

    @AfterEach
    void tearDown() throws Exception {
        this.q = null;
        this.s1 = null;
        this.s2 = null;
        this.s3 = null;
        // TODO: ??? null -> null???
        this.s4 = null;
    }

    @Test
    void testlongestCommonPrefixSolution1() {
        assertEquals("fl", q.longestCommonPrefixSolution1(s1));
        assertEquals("", q.longestCommonPrefixSolution1(s2));
        assertEquals("", q.longestCommonPrefixSolution1(s3));
        assertEquals("", q.longestCommonPrefixSolution1(s4));
    }

}
