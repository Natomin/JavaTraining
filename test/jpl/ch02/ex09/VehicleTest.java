package jpl.ch02.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Vehicle();
		Vehicle car3 = new Vehicle();
		Vehicle car4 = new Vehicle();
		Vehicle car5 = new Vehicle();
		Vehicle car6 = new Vehicle();
		
		assertEquals(car6.getId(), Vehicle.maxId());
		
	}

}
