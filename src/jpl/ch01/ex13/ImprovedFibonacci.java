package jpl.ch01.ex13;

//printlfではなくprintfを使用
public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	// 偶数要素に*をつけて表示する
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.printf("1: %d%n", lo);
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0) {
				mark = " *";
			} else {
				mark = " ";
			}
			//System.out.printf(i + ": " + hi + mark + "%n");
			System.out.printf("%d: %d %s%n", i, hi, mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
