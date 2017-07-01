package jpl.ch22.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitStringTest {

	@Test
	public void test() {
		String data = "12.3 23.4 34.5 45.6";
		double expected = 12.3 + 23.4 + 34.5 + 45.6;
		SplitString splitter = new SplitString();
		double actual = splitter.sum(data);
		System.out.println(expected);
		System.out.println(actual);
		
		assertEquals(expected, actual, 1E-15);
	}

}
