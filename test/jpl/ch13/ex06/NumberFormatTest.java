package jpl.ch13.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatTest {

	@Test
	public void test() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "1543729";
		numData = numFormat.numberFormatter(numData, 3, ",");
		System.out.println(numData);
		assertTrue(numData.intern() == "1,543,729");
	}
	@Test
	public void test2() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "15437295674";
		numData = numFormat.numberFormatter(numData, 2, "/");
		System.out.println(numData);
		assertTrue(numData.intern() == "1/54/37/29/56/74");
	}

}
