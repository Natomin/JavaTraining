package jpl.ch06.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayOfWeekTest {
	@Test
	public void test() {
		assertEquals(DayOfWeek.MONDAY.toString(), "MONDAY");
	}
	@Test
	public void test2() {
		assertEquals(DayOfWeek.THURSDAY.toString(), "THURSDAY");
	}
	@Test
	public void test3() {
		assertEquals(DayOfWeek.WEDNESDAY.toString(), "WEDNESDAY");
	}
	@Test
	public void test4() {
		assertEquals(DayOfWeek.THURSDAY.toString(), "THURSDAY");
	}
	@Test
	public void test5() {
		assertEquals(DayOfWeek.FRIDAY.toString(), "FRIDAY");
	}
	@Test
	public void test6() {
		assertEquals(DayOfWeek.SATURDAY.toString(), "SATURDAY");
	}
	@Test
	public void test7() {
		assertEquals(DayOfWeek.SUNDAY.toString(), "SUNDAY");
	}

}
