package jpl.ch14.ex05;
//14.4を修正してstaticの同期されたメソッドを使用しないでスレッドが安全に値を原産できるようにする。
public class ValueSyncState {
	private static int value = 0;
	
	public static synchronized void add(){
		value++;
		System.out.println(value);
	}
	
	public static void sub(){
		synchronized (ValueSyncState.class) {
			value--;
			System.out.println(value);
		}
	}

}
