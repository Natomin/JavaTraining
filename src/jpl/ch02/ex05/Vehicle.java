package jpl.ch02.ex05;
//フィールドの表示用にprintメソッドを追加

public class Vehicle {
	public static int nextID;
	public double velocity;
	public double deg;
	public String driverName;
	public final int id = nextID;
	
	public void print() {
		System.out.println("id = " + id);
		System.out.println("driver = " + driverName);
		System.out.println("Velocity = " + velocity);
		System.out.println("Deg = " + deg + "°");
	}
}
