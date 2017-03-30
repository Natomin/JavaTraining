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
	
	@Test
	public void test2() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "1";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "1");
	}
	
	@Test
	public void test3() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "15";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "15");
	}
	
	@Test
	public void test4() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "154";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "154");
	}
	
	@Test
	public void test5() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "1543";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "1,543");
	}
	
	@Test
	public void test6() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "15437";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "15,437");
	}
	
	@Test
	public void test7() {
		NumberFormat numFormat = new NumberFormat();
		String numData = "";
		numData = numFormat.numberFormatter(numData);
		System.out.println(numData);
		assertTrue(numData.intern() == "");
	}
	
	

}
