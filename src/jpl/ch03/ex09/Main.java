package jpl.ch03.ex09;

import jpl.ch03.ex08.Vehicle;

public class Main {

	public static void main(String[] args) {
		Vehicle car1 = new Vehicle("a", 20, 30);
		Vehicle car2 = new Vehicle("b", 30, 40);
		Garage testGarage = new Garage(car1, car2);
		System.out.println(testGarage.main(testGarage));
	}

}
