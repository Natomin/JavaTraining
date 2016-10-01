package jpl.ch01.ex04;
//なんらかの数列を生成するプログラムを作成（平方表を作成）

public class SquareTable {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i + "×" + i + "=" + i * i);
		}
	}

}
