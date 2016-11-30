package jpl.ch03.ex06;
//追加したEnergySourceの部分だけテストする
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {
	@Test
	public void test() {
		Vehicle car = new Vehicle("aaa", 80, 20, new Battery(80));
		assertTrue(car.start());
	}
	
	@Test
	public void test2() {
		Vehicle car = new Vehicle("aaa", 80, 20, new Battery(79));
		assertTrue(car.start());
	}
	@Test
	public void test3() {
		Vehicle car = new Vehicle("aaa", 80, 20, new Battery(11));
		assertTrue(car.start());
	}
	@Test
	public void test4() {
		Vehicle car = new Vehicle("aaa", 80, 20, new Battery(10));
		assertFalse(car.start());
	}
	@Test
	public void test5() {
		Vehicle car = new Vehicle("aaa", 80, 20, new GasTank(50));
		assertTrue(car.start());
	}
	
	@Test
	public void test6() {
		Vehicle car = new Vehicle("aaa", 80, 20, new GasTank(49));
		assertTrue(car.start());
	}
	@Test
	public void test7() {
		Vehicle car = new Vehicle("aaa", 80, 20, new GasTank(6));
		assertTrue(car.start());
	}
	@Test
	public void test8() {
		Vehicle car = new Vehicle("aaa", 80, 20, new GasTank(5));
		assertFalse(car.start());
	}

}
