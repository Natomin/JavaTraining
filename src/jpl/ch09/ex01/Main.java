package jpl.ch09.ex01;

import jpl.ch09.ex01.Calculator.Infinity;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.add(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.add(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.add(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY);
		calculator.subtract(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.subtract(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.subtract(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY);
		calculator.multiply(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.multiply(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.multiply(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY);
		calculator.divide(Infinity.NEGATIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.divide(Infinity.POSITIVE_INFINITY, Infinity.POSITIVE_INFINITY);
		calculator.add(Infinity.NEGATIVE_INFINITY, Infinity.NEGATIVE_INFINITY);
	}

}
