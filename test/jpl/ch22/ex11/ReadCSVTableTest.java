package jpl.ch22.ex11;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ReadCSVTableTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		List<String[]> list = ReadCSVTable.readCSVTable(new FileReader("./src/jpl/ch22/ex11/TestFile.txt"));
		for(String[] l :list){
			for(String s : l){
				System.out.print(s);
			}
			System.out.println();
		}
	}

}
