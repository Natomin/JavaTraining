package jpl.ch03.ex06;
//EnergySourceを継承、emptyメソッドを追加
public class Battery extends EnergySource{
	private int battery;

	public Battery(int battery) {
		super();
		this.battery = battery;
	}
	@Override
	fuelLevel empty() {
		if(battery >= 90){
			return fuelLevel.FULL;
		}else if(10 < battery || battery < 80){
			return fuelLevel.HALF;
		}else{
			return fuelLevel.EMPTY;
		}
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
}
