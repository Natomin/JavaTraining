package jpl.ch22.ex05;

public class Dice {

	// サイコロを振る
	public static int roll() {
		int num = (int) (Math.random() * 6) + 1;
		return num;
	}

}
