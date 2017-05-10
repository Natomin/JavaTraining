package jpl.ch20.ex05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindChar {
	int match;
	FileReader fileIn;
	LineNumberReader in;

	public FindChar(char match, String file) throws FileNotFoundException {
		this.match = match;
		fileIn = new FileReader(file);
		in = new LineNumberReader(fileIn);
	}

	public void find() throws IOException {
		String line;
		while ((line = in.readLine()) != null) {
			int lineNum = in.getLineNumber();
			for (int i = 0; i < line.length(); i++) {
				int ch = line.charAt(i);
				if (ch == match) {
					System.out.println(lineNum + ":" + line);
					break;
				}
			}
		}
		in.close();
	}
}
