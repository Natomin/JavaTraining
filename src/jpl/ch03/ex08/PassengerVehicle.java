package jpl.ch03.ex08;
//PassengerVehicleクラスをCloneable型にする
//finalのフィールド、配列がないのでObject.cloneで単純な値のコピー行う
public class PassengerVehicle extends Vehicle implements Cloneable{
	private int seatsNum;
	private int filledSeatsNum = 0;
	
	public PassengerVehicle clone() throws CloneNotSupportedException{
		try{
			return (PassengerVehicle) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	
	public PassengerVehicle(String driverName, double velocity, double deg){
		super(driverName, velocity, deg);
		seatsNum = 0;
	}
	public PassengerVehicle(String driverName, double velocity, double deg, int seatsNum){
		super(driverName, velocity, deg);
		this.seatsNum = seatsNum;
	}
	public final int getSeatsNum(){
		return seatsNum;
	}
	public final void setFilledSeatsNum(int filledSeatsNum){
		this.filledSeatsNum = filledSeatsNum;
	}
	public final int getFilledSeatsNum(){
		return filledSeatsNum;
	}
	public String toString(){
		String desc = super.toString() + seatsNum + "人乗り ";
		return desc;
	}

}
