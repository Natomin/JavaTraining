package jpl.ch03.ex09;
//何個かのVehicleオブジェクトを配列に保持できるGarageクラスを作成する
//GarageクラスをCloneable型にして、適切なcloneメソッドを追加する
//→配列のcloneなので、参照する配列を共有する単純なコピーではなく、参照先を独立させる
//cloneをテストするGarage.mainメソッド追加する
import jpl.ch03.ex08.Vehicle;

public class Garage implements Cloneable{
	
	protected Vehicle[] garage;
	
	public Garage(Vehicle... vehicle){
		garage = new Vehicle[vehicle.length];
		garage = vehicle;
	}
	
	public Garage clone() throws CloneNotSupportedException{
		try{
			Garage clone = (Garage) super.clone();
			clone.garage = garage.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	
	public boolean main(Garage sampleGarage){
		Vehicle[] testGarage = new Vehicle[2];
		Vehicle carA = new Vehicle("aaa", 200, 300);
		Vehicle carB = new Vehicle("bbb", 400, 500);
		testGarage[0] = carA;
		testGarage[1] = carB;
		
		try {
			Garage clone = sampleGarage.clone();
			clone.garage = testGarage;
			if(this.garage.equals(clone.garage)){
				return false;
			}else{
				return true;
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return false;
	}
}
