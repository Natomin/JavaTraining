package jpl.ch04.ex01;
//3.6の回答を抽象クラスではなくインタフェースを使用して書き換える
public interface EnergySource {
	enum fuelLevel{FULL, HALF, EMPTY};
	fuelLevel empty();

}
