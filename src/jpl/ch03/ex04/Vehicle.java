package jpl.ch03.ex04;
//どのメソッドをfinalにするのが適切か
//→getter、setterをfinalに変更
public class Vehicle {
	public enum Direction{LEFT, RIGHT}
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
	
	public void turn(Direction turn , int deg){
		switch (turn) {
		case LEFT:
			this.deg = -deg;
			break;
		case RIGHT:
			this.deg = deg;
			break;
		default:
			break;
		}
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

	public final int getId() {
		return id;
	}

	public final String getDriverName() {
		return driverName;
	}

	public final void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public final double getVelocity() {
		return velocity;
	}

	public final void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public final double getDeg() {
		return deg;
	}

	public final void setDeg(double deg) {
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
