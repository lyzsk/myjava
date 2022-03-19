package cn.sichu.myjava.november2021.cuproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkyScrapersTest {

    int[][] clues;
    int[][][] outcomes;

    @BeforeEach
    void setUp() throws Exception {
        this.clues = new int[][] {{2, 2, 1, 3, 2, 2, 3, 1, 1, 2, 2, 3, 3, 2, 1, 3},
            {0, 0, 1, 2, 0, 2, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0}};
        this.outcomes = new int[][][] {{{1, 3, 4, 2}, {4, 2, 1, 3}, {3, 4, 2, 1}, {2, 1, 3, 4}},
            {{2, 1, 4, 3}, {3, 4, 1, 2}, {4, 2, 3, 1}, {1, 3, 2, 4}}};
    }

    @AfterEach
    void tearDown() throws Exception {
        this.clues = null;
        this.outcomes = null;
    }

    @Test
    void testSolvePuzzle1() {
        assertEquals(SkyScrapers.solvePuzzle(clues[0]), outcomes[0]);
    }

    @Test
    void testSolvePuzzle2() {
        assertEquals(SkyScrapers.solvePuzzle(clues[1]), outcomes[1]);
    }
}
