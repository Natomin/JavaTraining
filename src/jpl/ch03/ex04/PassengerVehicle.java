package jpl.ch03.ex04;
//どのメソッドをfinalにするべきか
//→getter、setterをfinalに変更
public class PassengerVehicle extends Vehicle{
	private int seatsNum;
	private int filledSeatsNum = 0;
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
