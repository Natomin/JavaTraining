package jpl.ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class GasTankTest {

	@Test
	public void test() {
		GasTank car = new GasTank(50);
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
		GasTank car = new GasTank(49);
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
		GasTank car = new GasTank(6);
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
		GasTank car = new GasTank(5);
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
