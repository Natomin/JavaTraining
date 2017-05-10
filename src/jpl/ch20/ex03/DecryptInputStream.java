package jpl.ch20.ex03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class DecryptInputStream extends FilterReader {

	private final byte encryptionKey = 2;

	protected DecryptInputStream(Reader in) {
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : (c ^ (byte) encryptionKey));
	}

	public static void main(String[] args) throws IOException {
		StringReader src = new StringReader(args[0]);
		FilterReader f = new DecryptInputStream(src);
		int c;
		while ((c = f.read()) != -1) {
			System.out.print((char) c);
		}
		f.close();
	}

}
