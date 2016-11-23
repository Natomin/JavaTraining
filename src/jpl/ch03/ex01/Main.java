package jpl.ch03.ex01;

public class Main {

	public static void main(String[] args) {
		PassengerVehicle car1 = new PassengerVehicle("aaa", 80, 25, 5);
		car1.setFilledSeatsNum(4);
		System.out.println(car1.toString());
		System.out.println("乗車人数：" + car1.getFilledSeatsNum());
		
		PassengerVehicle car2 = new PassengerVehicle("bbb", 100, 90, 2);
		car2.setFilledSeatsNum(2);
		System.out.println(car2.toString());
		System.out.println("乗車人数：" + car2.getFilledSeatsNum());
	}

}
