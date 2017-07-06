package jpl.ch22.ex12;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import jpl.ch22.ex04.Attr;

public class AttrReaderTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		AttributedImpl attrs = (AttributedImpl) AttrReader.readAttrs(new FileReader("./src/jpl/ch22/ex12/AttrText.txt"));
		for(Attr a : attrs){
			System.out.println(a.toString());
		}
	}

}
