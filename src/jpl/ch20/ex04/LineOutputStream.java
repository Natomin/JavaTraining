package jpl.ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineOutputStream extends FilterReader {

	public LineOutputStream(Reader in) {
		super(in);
	}

	public String readLine() throws IOException {
		StringBuilder buffer = new StringBuilder();
		int c;
		do {
			c = super.read();
			if (c == -1) {
				return (buffer.toString());
			}
			buffer.append((char) c);
		} while (c != '\n' && c != '\r');
		return (buffer.toString());
	}

}
