package jpl.ch17.ex01;
//起動時と多くのオブジェクトを生成した後で利用可能なメモリ量を調べるプログラムを書く
//GCを呼び出して空きメモリ量がどのように変化するか調べる
public class SystemMemory {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long isFree = rt.freeMemory();
		System.out.println("起動時：" + isFree);
		StringBuffer[] garbageObj = new StringBuffer[10000000];
		isFree = rt.freeMemory();
		System.out.println("生成後：" + isFree);
		rt.gc();
		isFree = rt.freeMemory();
		System.out.println("gc後　：" + isFree);
	}

}
