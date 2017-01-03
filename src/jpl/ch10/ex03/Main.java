package jpl.ch10.ex03;

import jpl.ch06.ex01.DayOfWeek;

public class Main {

	public static void main(String[] args) {
		Week week = new Week();
		System.out.println(week.weekDay(DayOfWeek.SUNDAY));
		System.out.println(week.weekDay(DayOfWeek.MONDAY));
		System.out.println(week.weekDay(DayOfWeek.TUESDAY));
		System.out.println(week.weekDay(DayOfWeek.WEDNESDAY));
		System.out.println(week.weekDay(DayOfWeek.THURSDAY));
		System.out.println(week.weekDay(DayOfWeek.FRIDAY));
		System.out.println(week.weekDay(DayOfWeek.SATURDAY));
	}

}
