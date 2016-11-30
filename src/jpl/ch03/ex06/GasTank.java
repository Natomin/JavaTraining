package jpl.ch03.ex06;
//EnergySourceを継承、emptyメソッドを追加
public class GasTank extends EnergySource{

	private int gasoline;
	
	public GasTank(int gasoline) {
		super();
		this.gasoline = gasoline;
	}
	@Override
	fuelLevel empty() {
		if(gasoline >= 50){
			return fuelLevel.FULL;
		}else if(5 < gasoline && gasoline < 50){
			return fuelLevel.HALF;
		}else{
			return fuelLevel.EMPTY;
		}
	}
	public int getGasoline() {
		return gasoline;
	}
	public void setGasoline(int gasoline) {
		this.gasoline = gasoline;
	}

}
