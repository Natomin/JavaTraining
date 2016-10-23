package jpl.ch02.ex07;
//2つのコンストラクタを追加する。1つは引数なしコンストラクタ。もう1つは最初の所有者の名前を引数に取る。
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
	public Vehicle(String driverName){
		this();
		this.driverName = driverName;
	}

	public void print() {
		System.out.println("id = " + id);
		System.out.println("driver = " + driverName);
		System.out.println("Velocity = " + velocity);
		System.out.println("Deg = " + deg + "°");
	}

}
