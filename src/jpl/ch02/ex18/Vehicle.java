package jpl.ch02.ex18;

public class Vehicle {
	private static final int TURN_LEFT = -90;
	private static final int TURN_RIGHT = 90;
	private static int nextID;
	private int id;
	private String driverName;
	private double velocity;
	private double deg;

	// nextID,idの変更はコンストラクタの中でのみ行う
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
	
	public void turn(double deg){
		this.deg = this.deg + deg;
	}
	
	public void turn(int turn){
		this.deg = this.deg + turn;
	}

	public void changeSpeed(double velocity){
		this.velocity = velocity;
	}
	
	public void stop(){
		velocity = 0;
	}
	
	public static int getNextID() {
		return nextID;
	}

	public int getId() {
		return id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	public String toString() {
		String desc = id + "　(" + driverName + ")　" + velocity + "km " + deg + "° ";
		return desc;
	}
	
	public void printName(){
		System.out.println("id:" + id);
		System.out.println("driverName:" + driverName);
		System.out.println("");
	}

}
