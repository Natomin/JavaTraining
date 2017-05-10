package jpl.ch20.ex05;


import java.io.IOException;

import org.junit.Test;

public class FindCharTest {

	@Test
	public void test() throws IOException {
		FindChar findChar = new FindChar('a', "/Users/fujimuranatsumi/Documents/readline.txt");
		findChar.find();
	}

}
