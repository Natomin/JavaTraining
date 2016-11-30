package jpl.ch03.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {//クローンとデータが一致していることを確認
		Vehicle car = new Vehicle("aaa", 60, 30);
		try {
			Vehicle clone = car.clone();
			assertTrue(car.toString().equals(clone.toString()));
		} catch (CloneNotSupportedException e) {
			fail();
			e.printStackTrace();
		}
		
	}

}
