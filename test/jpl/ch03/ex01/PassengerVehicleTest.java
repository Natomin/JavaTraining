package jpl.ch03.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void test() {
		PassengerVehicle car1 = new PassengerVehicle("aaa", 80, 25, 5);
		car1.setFilledSeatsNum(4);
		assertEquals("0　(aaa)　80.0km 25.0° 5人乗り ", car1.toString());
		assertEquals(4, car1.getFilledSeatsNum());
		
		PassengerVehicle car2 = new PassengerVehicle("bbb", 100, 90, 2);
		car2.setFilledSeatsNum(2);
		assertEquals("1　(bbb)　100.0km 90.0° 2人乗り ", car2.toString());
		assertEquals(2, car2.getFilledSeatsNum());
	}

}
