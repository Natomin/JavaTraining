package jpl.ch02.ex13;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {
	private double velocity = 100;
	private double deg = 30;
	private String driverName = "name";

	@Test
	public void test() {
		Vehicle car = new Vehicle(driverName, velocity, deg);

		assertEquals(velocity, car.getVelocity(), 1e10);
		assertEquals(deg, car.getDeg(), 1e10);
		assertEquals(driverName, car.getDriverName());
	}
}
