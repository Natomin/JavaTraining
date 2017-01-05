package jpl.ch10.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch06.ex01.DayOfWeek;

public class WeekTest {

	@Test
	public void test() {
		Week week = new Week();
		assertFalse(week.weekDay(DayOfWeek.SUNDAY));
		assertTrue(week.weekDay(DayOfWeek.MONDAY));
		assertTrue(week.weekDay(DayOfWeek.TUESDAY));
		assertTrue(week.weekDay(DayOfWeek.WEDNESDAY));
		assertTrue(week.weekDay(DayOfWeek.THURSDAY));
		assertTrue(week.weekDay(DayOfWeek.FRIDAY));
		assertFalse(week.weekDay(DayOfWeek.SATURDAY));
	}

}
