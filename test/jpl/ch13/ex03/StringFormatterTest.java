package jpl.ch13.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringFormatterTest {

	@Test
	public void test() {
		StringFormatter formatter = new StringFormatter();
		String sampleString = "asdfgayhjdgxartgcvbdxseahbdwea";
		String[] test;
		String[] correct = {"asd".intern(), "ayhjd".intern(), "artgcvbd".intern(), "ahbd".intern(), "a".intern()};
		test = formatter.delimitedString(sampleString, 'a', 'd');
		for (int i = 0; i < test.length; i++) {
			String string = test[i];
			if(string != null){
				System.out.println(string);
				if(string.intern() != correct[i]){
					fail();
				}
			}
		}
	}

}
