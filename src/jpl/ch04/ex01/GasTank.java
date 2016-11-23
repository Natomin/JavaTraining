package jpl.ch04.ex01;

public class GasTank implements EnergySource{
	private int gasoline;
	public GasTank(int gasoline) {
		this.gasoline = gasoline;
	}

	@Override
	public fuelLevel empty() {
		if(gasoline >= 50){
			return fuelLevel.FULL;
		}else if(5 < gasoline || gasoline < 50){
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
