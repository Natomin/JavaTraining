package jpl.ch20.ex03;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class EncryptOutputStream extends FilterWriter{
	
	private final byte encryptionKey = 2;
	
	protected EncryptOutputStream(Writer out) {
		super(out);
	}

	public void write(int c) throws IOException {
		super.write(c ^ (byte) encryptionKey);
	}
	
	public static void main(String[] args) throws IOException {
		FilterWriter f = new EncryptOutputStream(new PrintWriter(System.out));
		String str = "vgqvFgap{rvKlrwvQvpgco";
		for(int i = 0; i < str.length(); i++){
			f.write(str.charAt(i));
		}
		f.close();
	}

}
