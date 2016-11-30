package jpl.ch06.ex04;
//enum定数が適切なSignalColorオブジェクトを持ち、そのオブジェクトをgetColorでとり出せるようにする
public enum SignalColor {
	RED,
	YELLOW,
	GREEN;
	
	public SignalColor getColor(){
		return this;
	}
	
}
