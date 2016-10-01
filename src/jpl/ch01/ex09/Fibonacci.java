package jpl.ch01.ex09;
//フィボナッチ数列を配列に保存して最後に値のリストを表示する

public class Fibonacci {
	static final int ARR_SIZE = 9;

	// 値が50未満フィボナッチ数列を表示する
	public static void main(String[] args) {
		int[] fibonacci = new int[ARR_SIZE];
		int lo = 1;
		int hi = 1;

		fibonacci[0] = lo;
		for (int i = 1; i < ARR_SIZE; i++) {
			fibonacci[i] = hi;
			hi = lo + hi;// 新しいhi
			lo = hi - lo;// 新しいloは（合計 - 古いlo）すなわち古いhi
		}
		System.out.print("{ ");
		for (int i = 0; i < ARR_SIZE; i++) {
			System.out.print(fibonacci[i]);
			System.out.print(" ");
		}
		System.out.println("}");
	}

}
