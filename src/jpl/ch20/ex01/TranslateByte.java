package jpl.ch20.ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static void main(String[] args) throws IOException {
		TranslateByte translate = new TranslateByte();
		InputStream in = new FileInputStream("/Users/fujimuranatsumi/Documents/workspace/JavaTraining/src/jpl/ch20/ex01/inputFile.txt");
		OutputStream out = new FileOutputStream("/Users/fujimuranatsumi/Documents/workspace/JavaTraining/src/jpl/ch20/ex01/outputFile.txt");
		translate.translateToByte((byte) 'u', (byte) 'U', in, out);
	}

	public void translateToByte(byte from, byte to, InputStream in, OutputStream out) throws IOException {
		int b;
		while ((b = in.read()) != -1) {
			out.write(b == from ? to : b);
		}
	}

}
