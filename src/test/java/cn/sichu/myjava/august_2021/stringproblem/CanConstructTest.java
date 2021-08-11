package cn.sichu.myjava.august_2021.stringproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanConstructTest {
	CanConstruct q;
	String ransomNote1, magazine1, ransomNote2, magazine2,
		   ransomNote3, magazine3;
	@BeforeEach
	void setUp() throws Exception {
		this.q = new CanConstruct();
		this.ransomNote1 = "a";
		this.magazine1 = "b";
		this.ransomNote2 = "aa";
		this.magazine2 = "ab";
		this.ransomNote3 = "aa";
		this.magazine3 = "aab";
	}

	@AfterEach
	void tearDown() throws Exception {
		this.q = null;
		this.ransomNote1 = null;
		this.magazine1 = null;
		this.ransomNote2 = null;
		this.magazine2 = null;
		this.ransomNote3 = null;
		this.magazine3 = null;
	}

	@Test
	void testCanConstruct() {
		assertEquals(false, q.canConstruct(ransomNote1, magazine1));
		assertEquals(false, q.canConstruct(ransomNote2, magazine2));
		assertEquals(true, q.canConstruct(ransomNote3, magazine3));
	}

}
