package jpl.ch03.ex04;

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
		car.turn(30);
		assertEquals(deg + 30, car.getDeg(), 1e10);
		car.turn(-50);
		assertEquals(deg + 30 - 50, car.getDeg(), 1e10);
	}
	
	@Test
	public void test2(){
		Vehicle car = new Vehicle(driverName, velocity, deg);
		assertEquals(velocity, car.getVelocity(), 1e10);
		assertEquals(deg, car.getDeg(), 1e10);
		assertEquals(driverName, car.getDriverName());
		car.turn(Vehicle.Direction.LEFT, 90);
		assertEquals(deg - 90, car.getDeg(), 1e10);
		car.turn(Vehicle.Direction.RIGHT, 90);
		assertEquals(deg, car.getDeg(), 1e10);
	}
}
