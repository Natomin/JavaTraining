package java8.ch02.ex01;

public class Counter {
	private int sum = 0;

	synchronized void count() {
		sum++;
	}

	synchronized int get() {
		return sum;
	}

}
