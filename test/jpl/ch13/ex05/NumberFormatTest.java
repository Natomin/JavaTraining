package jpl.ch13.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatTest {

	@Test
	public void test() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "1543729";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "1,543,729");
	}

}
