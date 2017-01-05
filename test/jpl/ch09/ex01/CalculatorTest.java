package jpl.ch09.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch09.ex01.Calculator.Infinity;

public class CalculatorTest {

	@Test
	public void test() {
		Calculator calculator = new Calculator();
		assertTrue(Double.isNaN(calculator.add(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY)));
		assertTrue(calculator.add(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY) == Double.POSITIVE_INFINITY);
		assertTrue(calculator.add(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY) == Double.NEGATIVE_INFINITY);
	}
	
	@Test
	public void test2() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.subtract(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY) == Double.NEGATIVE_INFINITY);
		assertTrue(Double.isNaN(calculator.subtract(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY)));
		assertTrue(Double.isNaN(calculator.subtract(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY)));
		
	}
	
	@Test
	public void test3() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.multiply(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY) == Double.NEGATIVE_INFINITY);
		assertTrue(calculator.multiply(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY) == Double.POSITIVE_INFINITY);
		assertTrue(calculator.multiply(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY) == Double.POSITIVE_INFINITY);
		
		
	}
	
	@Test
	public void test4() {
		Calculator calculator = new Calculator();
		assertTrue(Double.isNaN(calculator.divide(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY)));
		assertTrue(Double.isNaN(calculator.divide(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY)));
		assertTrue(Double.isNaN(calculator.divide(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY)));
			
	}

}
