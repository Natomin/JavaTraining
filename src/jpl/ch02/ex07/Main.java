package jpl.ch02.ex07;
//driverNameをコンストラクタの引数で渡す

public class Main {

	public static void main(String[] args) {
		Vehicle car = new Vehicle("aaa");
		Vehicle bus = new Vehicle("bbb");
		Vehicle bicycle = new Vehicle("ccc");
		
		car.velocity = 100;
		car.deg = 30;
		System.out.println("[car]");
		car.print();
		
		bus.velocity = 40;
		bus.deg = 45;
		System.out.println("[bus]");
		bus.print();
		
		bicycle.velocity = 15;
		bicycle.deg = 60;
		System.out.println("[bicycle]");
		bicycle.print();
	}

	}
