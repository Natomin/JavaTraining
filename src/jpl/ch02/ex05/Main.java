package jpl.ch02.ex05;
//Vehicleクラスにmainメソッドを書いて、数個の乗り物を作成し、それらのオブジェクトのフィールドを表示する

public class Main {
	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle.nextID++;
		Vehicle bus = new Vehicle();
		Vehicle.nextID++;
		Vehicle bicycle = new Vehicle();
		Vehicle.nextID++;
		
		car.driverName = "aaa";
		car.velocity = 100;
		car.deg = 30;
		System.out.println("[car]");
		car.print();
		
		bus.driverName = "bbb";
		bus.velocity = 40;
		bus.deg = 45;
		System.out.println("[bus]");
		bus.print();
		
		bicycle.driverName = "ccc";
		bicycle.velocity = 15;
		bicycle.deg = 60;
		System.out.println("[bicycle]");
		bicycle.print();
	}

}
