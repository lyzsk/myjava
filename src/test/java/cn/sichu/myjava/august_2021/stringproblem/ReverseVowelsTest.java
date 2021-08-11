package cn.sichu.myjava.august_2021.stringproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReverseVowelsTest {
	ReverseVowels q;
	String s1, s2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.q = new ReverseVowels();
		this.s1 = new String("hello");
		this.s2 = new String("leetcode");
	}

	@AfterEach
	void tearDown() throws Exception {
		this.q = null;
		this.s1 = null;
		this.s2 = null;
	}

	@Test
	void testReverseVowels() {
		assertEquals("holle", q.reverseVowels(s1));
		assertEquals("leotcede", q.reverseVowels(s2));
	}

	@ParameterizedTest
	@ValueSource(chars = {'a', 'A',
						  'e', 'E',
						  'i', 'I',
						  'o', 'O',
						  'u', 'U'})
	void testIsVowel(Character c) {
		assertTrue(c == 'a' || c == 'A' || 
				   c == 'e' || c == 'E' ||
				   c == 'i' || c == 'I' ||
				   c == 'o' || c == 'O' ||
				   c == 'u' || c == 'U');
	}
}
