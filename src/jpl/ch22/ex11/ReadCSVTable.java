package jpl.ch22.ex11;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVTable {
	public static List<String[]> readCSVTable(FileReader source) throws IOException{
		List<String[]> vals = new ArrayList<>();
		StreamTokenizer in = new StreamTokenizer(source);
		in.resetSyntax();
		in.wordChars('0', '9');
		in.wordChars('a', 'z');
		in.wordChars('A', 'Z');
		in.wordChars('_', '_');
		in.whitespaceChars(',', ',');
		in.whitespaceChars(' ', ' ');
		in.whitespaceChars('\t', '\t');
		in.whitespaceChars('\n', '\n');
		in.whitespaceChars('\r', '\r');
		in.eolIsSignificant(true);
		
		int token;
		List<String> str = new ArrayList<>(4);
		while ((token = in.nextToken()) != StreamTokenizer.TT_EOF) {
			switch (token) {
			case StreamTokenizer.TT_EOL:
				vals.add(str.toArray(new String[4]));
				str.clear();
				break;
			case StreamTokenizer.TT_NUMBER:
				str.add(Double.toString(in.nval));
			case StreamTokenizer.TT_WORD:
				str.add(in.sval);
				break;
			default:
			}
		}
		if(!str.isEmpty()){
			vals.add(str.toArray(new String[4]));
		}
		return vals;
	}
	

}
