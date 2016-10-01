package jpl.ch01.ex10;
//数列を配列に保存、数列の値とその値が偶数が奇数かを示すブール値を保持するクラスを生成
//そのクラスのオブジェクトへの参照を配列として持つようにする

public class Fibonacci {

	static final int ARR_SIZE = 9;

	// 偶数要素に*をつけて表示する
	public static void main(String[] args) {
		DataStorage[] fibonacciData = new DataStorage[ARR_SIZE];
		int lo = 1;
		int hi = 1;
		fibonacciData[0] = new DataStorage();
		fibonacciData[0].setData(lo, DataStorage.ODD);
		for (int i = 1; i < ARR_SIZE; i++) {
			fibonacciData[i] = new DataStorage();
			if (hi % 2 == 0) {
				fibonacciData[i].setData(hi, DataStorage.EVEN);
			} else {
				fibonacciData[i].setData(hi, DataStorage.ODD);
			}
			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i = 0; i < ARR_SIZE; i++) {
			fibonacciData[i].print();
		}
	}

}
