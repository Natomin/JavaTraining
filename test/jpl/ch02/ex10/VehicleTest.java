package jpl.ch02.ex10;
//目視で確認

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle car1 = new Vehicle("aaa", 120, 30);
		Vehicle car2 = new Vehicle("bbb", 20, 40);
		Vehicle car3 = new Vehicle("ccc", 80, 50);
		
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
	}
}