package jpl.ch22.ex08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


public class ReadCSV {
	public static List<String[]> readCSVTable(Readable source, int cellsNum) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^([^,]*)";
		for (int i = 1; i < cellsNum; i++) {
			exp = exp + ",([^,]*)$";
		}
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[cellsNum];
				MatchResult match = in.match();
				for (int i = 0; i < cellsNum; i++) {
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				in.nextLine();
			} else {
				String l = in.nextLine();
				if (!l.equals(" ")) {
					in.close();
					throw new IOException("input format error");
				}
			}
		}
		IOException ex = in.ioException();
		if (ex != null) {
			in.close();
			throw ex;
		}
		in.close();
		return vals;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String[]> list = ReadCSV.readCSVTable(new FileReader("./src/jpl/ch22/ex11/TestFile.txt"), 4);
		for (String[] l : list) {
			for (String s : l) {
				System.out.print(s);
			}
			System.out.println();
		}
	}

}
