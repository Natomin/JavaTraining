package jpl.ch14.ex04;
//14.3を修正してstaticデータとstaticメソッドを使用するようにする
public class ValueStatic {
	private static int value = 0;
	
	public static synchronized void add(){
		value++;
		System.out.println(value);
	}
	

}
