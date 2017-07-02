package java8.ch01.ex01;

import java.util.Comparator;

public class LengthComparator implements Comparator<String>{
	@Override
	public int compare(String first, String second) {
		System.out.println(Thread.currentThread().getName());
		return Integer.compare(first.length(), second.length());
	}
}

