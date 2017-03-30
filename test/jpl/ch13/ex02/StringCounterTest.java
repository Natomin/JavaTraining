package jpl.ch13.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCounterTest {

	@Test
	public void test() {
		StringCounter charCount = new StringCounter();
		assertTrue(charCount.countString("cocoa", "co") == 2);
	}
	
	@Test
	public void test2() {
		StringCounter charCount = new StringCounter();
		assertTrue(charCount.countString("namamuginamagomenamatamago", "nama") == 3);
	}
	
	@Test
	public void test3() {
		StringCounter charCount = new StringCounter();
		assertTrue(charCount.countString("migimiminomiginiminimigimimi", "migi") == 3);
	}
	@Test
	public void test4() {
		StringCounter charCount = new StringCounter();
		assertTrue(charCount.countString("migimiminomiginiminimigimimi", "migimimi") == 2);
	}

	@Test
	public void test5() {
		StringCounter charCount = new StringCounter();
		assertTrue(charCount.countString("aaaaa", "aa") == 4);
	}
}
