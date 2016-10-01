package jpl.ch01.ex10;

public class DataStorage {

	static final int ODD = 0;
	static final int EVEN = 1;
	private int numData;
	private int boolData;

	public void setData(int num, int bool) {
		this.numData = num;
		this.boolData = bool;
	}

	public void print() {
		System.out.print(numData);
		if (boolData == EVEN) {
			System.out.println(" *");
		} else {
			System.out.println(" ");
		}
	}
}
