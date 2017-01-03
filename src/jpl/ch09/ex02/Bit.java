package jpl.ch09.ex02;
//ビット操作演算子だけを用いて、渡されたintで1となっているビット数を調べるメソッドを作成する。
public class Bit {
	public int bitCount(int data){
		int count = 0;
		for(int i = 0; i < Integer.valueOf(data).SIZE; i++){
			if((data & 1) == 1){
				count++;
			}
			data = data >>> 1;
		}
		return count;
	}
}
