package jpl.ch01.ex06;
//出力するタイトルに名前付き文字列定数を使用

public class Fibonacci {
	static final String TITLE = "フィボナッチ数列";

	// 値が50未満フィボナッチ数列を表示する
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println(TITLE);
		System.out.println(lo);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + hi;// 新しいhi
			lo = hi - lo;// 新しいloは（合計 - 古いlo）すなわち古いhi
		}
	}

}
