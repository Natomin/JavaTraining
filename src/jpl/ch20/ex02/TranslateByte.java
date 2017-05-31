package jpl.ch20.ex02;

import java.io.FilterReader;
//TODO バッファを引数で渡す方が足りていない
//TODO byteにキャストして範囲を同じにしてから比較
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte extends FilterReader {
	byte from;
	byte to;
	public TranslateByte(Reader in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == from ? to : c);
	}

	public static void main(String[] args) throws IOException {
		StringReader src = new StringReader(args[0]);
		FilterReader f = new TranslateByte(src, (byte)'a', (byte)'A');
		int c;
		while((c = f.read()) != -1){
			System.out.print((char)c);
		}
	}

}
