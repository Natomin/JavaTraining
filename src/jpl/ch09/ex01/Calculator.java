package jpl.ch09.ex01;

public class Calculator {
	public enum Infinity{ NEGATIVE_INFINITY, POSITIVE_INFINITY }
	
	public double add(Infinity a, Infinity b) {
		double x = 0;
		double y = 0;
		double result;
		if(a == Infinity.NEGATIVE_INFINITY){
			x = Double.NEGATIVE_INFINITY;
		}else if(a == Infinity.POSITIVE_INFINITY){
			x = Double.POSITIVE_INFINITY;
		}
		if(b == Infinity.NEGATIVE_INFINITY){
			y = Double.NEGATIVE_INFINITY;
		}else if(b == Infinity.POSITIVE_INFINITY){
			y = Double.POSITIVE_INFINITY;
		}
		result = x + y;
		System.out.println(x + " + " + y +" = " + result);
		return result;
	}
	
	public double subtract(Infinity a, Infinity b) {
		double x = 0;
		double y = 0;
		double result;
		if(a == Infinity.NEGATIVE_INFINITY){
			x = Double.NEGATIVE_INFINITY;
		}else if(a == Infinity.POSITIVE_INFINITY){
			x = Double.POSITIVE_INFINITY;
		}
		if(b == Infinity.NEGATIVE_INFINITY){
			y = Double.NEGATIVE_INFINITY;
		}else if(b == Infinity.POSITIVE_INFINITY){
			y = Double.POSITIVE_INFINITY;
		}
		result = x - y;
		System.out.println(x + " - " + y +" = " + result);
		return result;
	}
	
	public double multiply(Infinity a, Infinity b) {
		double x = 0;
		double y = 0;
		double result;
		if(a == Infinity.NEGATIVE_INFINITY){
			x = Double.NEGATIVE_INFINITY;
		}else if(a == Infinity.POSITIVE_INFINITY){
			x = Double.POSITIVE_INFINITY;
		}
		if(b == Infinity.NEGATIVE_INFINITY){
			y = Double.NEGATIVE_INFINITY;
		}else if(b == Infinity.POSITIVE_INFINITY){
			y = Double.POSITIVE_INFINITY;
		}
		result = x * y;
		System.out.println(x + " × " + y +" = " + result);
		return result;
	}

	public double divide(Infinity a, Infinity b) {
		double x = 0;
		double y = 0;
		double result;
		if(a == Infinity.NEGATIVE_INFINITY){
			x = Double.NEGATIVE_INFINITY;
		}else if(a == Infinity.POSITIVE_INFINITY){
			x = Double.POSITIVE_INFINITY;
		}
		if(b == Infinity.NEGATIVE_INFINITY){
			y = Double.NEGATIVE_INFINITY;
		}else if(b == Infinity.POSITIVE_INFINITY){
			y = Double.POSITIVE_INFINITY;
		}
		result = x / y;
		System.out.println(x + " ÷ " + y +" = " + result);
		return result;
	}
}
