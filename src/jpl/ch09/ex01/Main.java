package jpl.ch09.ex01;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.add(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.add(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.add(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		calculator.subtract(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.subtract(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.subtract(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		calculator.multiply(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.multiply(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.multiply(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		calculator.divide(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.divide(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		calculator.divide(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
	}

}
