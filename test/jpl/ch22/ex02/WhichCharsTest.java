package jpl.ch22.ex02;


import org.junit.Test;

public class WhichCharsTest {

	@Test
	public void test() {
		String str = "Testing 1 2 3";
		WhichChars whichChars = new WhichChars(str);
		System.out.println(whichChars.toString());
	}

}
