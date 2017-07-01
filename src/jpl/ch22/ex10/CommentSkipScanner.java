package jpl.ch22.ex10;

import java.io.IOException;
import java.util.Scanner;

public class CommentSkipScanner {
	public String scan(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		in.useDelimiter("\n|\n#.*");//改行または改行とコメント文
		// ・・・
		String s = null;
		while (in.hasNext()) {
			s = in.next();
		}
		in.close();
		return s;
	}
}
