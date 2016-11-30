package jpl.ch03.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void test() {//クローンとデータが一致していることを確認
		PassengerVehicle car = new PassengerVehicle("aaa", 60, 30, 4);
		try {
			PassengerVehicle clone = car.clone();
			assertTrue(car.toString().equals(clone.toString()));
		} catch (CloneNotSupportedException e) {
			fail();
			e.printStackTrace();
		}
		
	}

}
