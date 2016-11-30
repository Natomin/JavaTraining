package jpl.ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class BatteryTest {

	@Test
	public void test() {
		Battery car = new Battery(80);
		switch (car.empty()) {
		case FULL:
			System.out.println("OK");
			break;
		case HALF:
			fail();
			break;
		case EMPTY:
			fail();
			break;
		default:
			System.out.println("サポートしていません");
			break;
		}
	}
	@Test
	public void test2() {
		Battery car = new Battery(79);
		switch (car.empty()) {
		case FULL:
			fail();
			break;
		case HALF:
			System.out.println("OK");
			break;
		case EMPTY:
			fail();
			break;
		default:
			System.out.println("サポートしていません");
			break;
		}
	}

	@Test
	public void test3() {
		Battery car = new Battery(11);
		switch (car.empty()) {
		case FULL:
			fail();
			break;
		case HALF:
			System.out.println("OK");
			break;
		case EMPTY:
			fail();
			break;
		default:
			System.out.println("サポートしていません");
			break;
		}
	}
	@Test
	public void test4() {
		Battery car = new Battery(10);
		switch (car.empty()) {
		case FULL:
			fail();
			break;
		case HALF:
			fail();
			break;
		case EMPTY:
			System.out.println("OK");
			break;
		default:
			System.out.println("サポートしていません");
			break;
		}
	}
}
