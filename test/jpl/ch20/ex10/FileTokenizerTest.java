package jpl.ch20.ex10;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FileTokenizerTest {

	@Test
	public void test() throws IOException {
		FileTokenizer tokenizer = new FileTokenizer(new FileReader(
				"/Users/fujimuranatsumi/Documents/workspace/JavaTraining/src/jpl/ch20/ex10/tokenizedfile.txt"));
		tokenizer.countToken();
		tokenizer.printMap();
	}

}
