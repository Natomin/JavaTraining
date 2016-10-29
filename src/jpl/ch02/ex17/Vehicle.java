package jpl.ch02.ex17;
//二つのturnメソッドと追加する
public class Vehicle {
	private static int nextID;
	private int id;
	private String driverName;
	private double velocity;
	private double deg;
	
	public enum TURN{LEFT, RIGHT}//enum

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
	/**
	 * 引数で渡す角度分、方角を変化させる関数
	 * @param deg
	 */
	public void turn(double deg){
		this.deg = this.deg + deg;
	}

	/**
	 * 角度degだけ方向directionに変化させる関数
	 * @param deg:変化させる角度
	 * @param direction:変化させる方向 turn.LEFTまたはturn.RIGHT
	 */
	public void turn(double deg, TURN direction){
		switch (direction) {
		case RIGHT:
			this.deg = this.deg + deg;
			break;
		case LEFT:
			this.deg = this.deg - deg;
			break;
		default:
			System.out.println("IllegalAegumrnt");
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
		String desc = id + "　(" + driverName + ")　" + velocity + "km " + deg + "°";
		return desc;
	}

}
