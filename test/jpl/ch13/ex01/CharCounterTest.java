package jpl.ch13.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharCounterTest {

	@Test
	public void test() {
		CharCounter charCount = new CharCounter();
		assertTrue(charCount.countChar("chocolate", 'c') == 2);
	}
	
	@Test
	public void test2() {
		CharCounter charCount = new CharCounter();
		assertTrue(charCount.countChar("chocolate", 'h') == 1);
	}
	
	@Test
	public void test3() {
		CharCounter charCount = new CharCounter();
		assertTrue(charCount.countChar("chocolate", 'o') == 2);
	}
	
	@Test
	public void test4() {
		CharCounter charCount = new CharCounter();
		assertTrue(charCount.countChar("chocolate", 'e') == 1);
	}
	
	@Test
	public void test5() {
		CharCounter charCount = new CharCounter();
		assertTrue(charCount.countChar("chocolate", 'b') == 0);
	}

}
