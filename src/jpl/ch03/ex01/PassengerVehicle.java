package jpl.ch03.ex01;
//ch02Vehicleクラスを拡張して車が持っている座席数と現在座っている人数を返す機能を追加する
public class PassengerVehicle extends jpl.ch02.ex18.Vehicle{
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
	public int getSeatsNum(){
		return seatsNum;
	}
	public void setFilledSeatsNum(int filledSeatsNum){
		this.filledSeatsNum = filledSeatsNum;
	}
	public int getFilledSeatsNum(){
		return filledSeatsNum;
	}
	public String toString(){
		String desc = super.toString() + seatsNum + "人乗り ";
		return desc;
	}

}
