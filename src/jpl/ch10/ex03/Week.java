package jpl.ch10.ex03;

import jpl.ch06.ex01.DayOfWeek;

public class Week {
	public boolean weekDay(DayOfWeek day) throws IllegalArgumentException {
		switch (day) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			return true;
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			throw new IllegalArgumentException("サポートされていない値です");
		}
	}

}
