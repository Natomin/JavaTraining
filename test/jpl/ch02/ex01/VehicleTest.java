package jpl.ch02.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {
	private double velocity = 100;
	private double deg = 30;
	private String driverName = "name";
	
	@Test
	public void test() {
		Vehicle car = new Vehicle();
		car.velocity = velocity;
		car.deg = deg;
		car.driverName = driverName;
		
		assertEquals(velocity, car.velocity, 1e10);
		assertEquals(deg, car.deg, 1e10);
		assertEquals(driverName, car.driverName);
		
	}

}
