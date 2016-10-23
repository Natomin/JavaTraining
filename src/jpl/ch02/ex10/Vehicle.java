package jpl.ch02.ex10;
//toStringメソッドを追加する
//コンストラクタで各フィールドの初期化を行うように修正（すべてのフィールドをprivateに変更）

public class Vehicle {
	private static int nextID;
	private int id;
	private String driverName;
	private double velocity;
	private double deg;

	public Vehicle() {
		id = nextID;
		nextID++;
	}

	public Vehicle(String driverName, double velocity, double deg) {
		this();
		this.driverName = driverName;
		this.velocity = velocity;
		this.deg = deg;
	}
	
	public String toString(){
		String desc = id + "　(" + driverName + ")　" + velocity + "km " + deg + "°";
		return desc;
	}
//
//	public void print() {
//		System.out.println("id = " + id);
//		System.out.println("driver = " + driverName);
//		System.out.println("Velocity = " + velocity);
//		System.out.println("Deg = " + deg + "°");
//	}

}
