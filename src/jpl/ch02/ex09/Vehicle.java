package jpl.ch02.ex09;
//今まで使われた識別番号の最大値を返すstaticメソッドを追加する

public class Vehicle {
	private static int nextID;
	private int id;
	private String driverName;
	public double velocity;
	public double deg;

	public Vehicle() {
		id = nextID;
		nextID++;
	}

	public Vehicle(String driverName) {
		this();
		this.driverName = driverName;
	}

	public void print() {
		System.out.println("id = " + id);
		System.out.println("driver = " + driverName);
		System.out.println("Velocity = " + velocity);
		System.out.println("Deg = " + deg + "°");
	}
	
	public static int maxId(){
		return nextID - 1;
	}
	
	public int getId(){
		return id;
	}

}
