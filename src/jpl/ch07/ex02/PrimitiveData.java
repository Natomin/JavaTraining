package jpl.ch07.ex02;
//各基本データ型のフィールドを宣言しているクラスを作成して、異なるリテラル形式を使用して値を代入してみる。
//どのリテラルがどのフィールド型と一緒に利用できるか。値の大きさを変えて影響を調べる。
public class PrimitiveData {
	// true or false
	boolean boolData = true;
	// \u0000〜\uFFFF
	char charData = '\u0000';
	// -128〜127
	byte byteData = -128;
	// -32768〜32767
	short shortData = 32767;
	// -2147483648〜2147483647
	int intData = 2147483647;
	// -9223372036854775808〜9223372036854775807
	long longData = 9223372036854775807L;
	// 32ビット単精度浮動小数点数
	float floatData = 3.4028235E+38F;
	// 64ビット倍精度浮動小数点数
	double doubleData = 1.79769313486231570E+308;

	public void boolData() {
		// コンパイルエラー
		// boolData = '\u0000';
		// boolData = -128;
		// boolData = 9223372036854775807L;
		// boolData = 3.4028235E+38F;
		// boolData = 1.79769313486231570E+308;
	}

	public void charData() {
		// charData = true;//コンパイルエラー
		charData = (char) 23L;// キャストが必要
		charData = (char) 0.4E+2F;// キャストが必要
		charData = (char) 1.1E+2;// キャストが必要
	}

	public void byteData() {
		byteData = '\u007F';// byteの範囲までなら文字リテラルで代入可能
		byteData = (byte) '\u00FF';// キャストが必要
		// byteData = true;//コンパイルエラー
		byteData = (byte) 23L;// キャストが必要
		byteData = (byte) 0.4E+2F;// キャストが必要
		byteData = (byte) 1.1E+2;// キャストが必要
	}

	public void shortData() {
		shortData = '\u7FFF';// shortの範囲までなら文字リテラルで代入可能
		shortData = (short) '\u8000';// キャストが必要
//		shortData = true;// コンパイルエラー
		shortData = (short) 32768L;// キャストが必要
		shortData = (short) 0.4E+2F;// キャストが必要
		shortData = (short) 1.1E+2;// キャストが必要
	}

	public void intData() {
		intData = '\uFFFF';//文字リテラルで代入可能
//		intData = true;// コンパイルエラー
		intData = (int) 922807L;// キャストが必要
		intData = (int) 3.40E+3F;// キャストが必要
		intData = (int) 1.79E+3;// キャストが必要
	}

	public void longData() {
		longData = '\uFFFF';//文字リテラルで代入可能
//		longData = true;// コンパイルエラー
		longData = (long) 3.40E+3F;// キャストが必要
		longData = (long) 1.79E+3;// キャストが必要
	}

	public void floatData() {
		floatData = '\uFFFF';//文字リテラルで代入可能
//		floatData = true;// コンパイルエラー
		floatData = 9223372036854775807L;
		floatData = (float) 3.4028235E+38;// キャストが必要
		floatData = (float) 1.79769313486231570E+308;// キャストが必要
	}
	
	public void doubleData() {
		doubleData = '\uFFFF';//文字リテラルで代入可能
//		doubleData = true;// コンパイルエラー
		doubleData = 2147483647;
		doubleData = 9223372036854775807L;
		doubleData = 3.4028235E+38F;
		doubleData = 1.79769313486231570E+308;
	}
}
