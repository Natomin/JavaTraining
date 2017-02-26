package jpl.ch14.ex03;
//現在の値を保持し、その値に加算して新たな値を表示するメソッドのクラスを作成する
//このオブジェクトを作成し、複数のスレッドを生成し、各スレッドからその加算メソッドを
//繰り返し呼び出すプログラムを作成する。（加算結果が失われないようにする）
public class Value {
	private int value = 0;
	
	public synchronized void add(){
		value++;
		System.out.println(value);
	}
	public int getValue(){
		return value;
	}
	

}
