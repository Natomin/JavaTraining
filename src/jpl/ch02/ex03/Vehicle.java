package jpl.ch02.ex03;
//Vehicleクラスに、次の乗り物の識別番号を保持するstaticフィールドと、車単位でID番号を保持するための非staticフィールドを追加する
public class Vehicle {
	public static int nextID;
	public double velocity;
	public double deg;
	public String driverName;
	public final int id = nextID;
}
