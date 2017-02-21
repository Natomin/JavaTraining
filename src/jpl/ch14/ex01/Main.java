package jpl.ch14.ex01;
//mainを実行しているスレッドの名前を表示するプログラムを作成する。
public class Main {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
	}

}
