package jpl.ch09.ex01;

public class Calculator {
	
	public void add(double x, double y) {
		double result;
		result = x + y;
		System.out.println(x + " + " + y +" = " + result);
	}
	public void subtract(double x, double y) {
		double result;
		result = x - y;
		System.out.println(x + " - " + y +" = " + result);
	}
	public void multiply(double x, double y) {
		double result;
		result = x * y;
		System.out.println(x + " × " + y +" = " + result);
	}
	public void divide(double x, double y) {
		double result;
		result = x / y;
		System.out.println(x + " ÷ " + y +" = " + result);
	}
}
