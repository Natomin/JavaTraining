package jpl.ch02.ex03;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex03Test {

	@Test
	public void test() {
		Vehicle car1 = new Vehicle();
		Vehicle.nextID++;
		assertEquals(0, car1.id);
		
		Vehicle car2 = new Vehicle();
		Vehicle.nextID++;
		assertEquals(1, car2.id);
		
		Vehicle car3 = new Vehicle();
		Vehicle.nextID++;
		assertEquals(2, car3.id);
	}

}
