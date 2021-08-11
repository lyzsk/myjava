package cn.sichu.myjava.august_2021.stringproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class LengthOfLongestSubStringTest {
	LengthOfLongestSubString q;
	
	@BeforeEach
	void setUp() throws Exception {
		this.q = new LengthOfLongestSubString();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.q = null;
	}

	@Test
	void testLengthOfLongestSubstring() {
		assertEquals(3, q.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, q.lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, q.lengthOfLongestSubstring("pwwkew"));
		assertEquals(0, q.lengthOfLongestSubstring(""));
	}
	
	@Test
	void testException() {
		assertThrows(NullPointerException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				q.lengthOfLongestSubstring(null);
			}
		});
	}

}
