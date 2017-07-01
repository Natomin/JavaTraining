package jpl.ch22.ex01;

public class FigureFormatter {
	public static void main(String[] args) {
		double[] arr = { 3.14159265, 31.4159265, 314.159265, 3141.59265, 3.14159265, 31.4159265, 314.159265, 3141.59265,
				3.14159265, 31.4159265, 314.159265, 3141.59265, 3.14159265, 31.4159265, 314.159265, 3141.59265,
				3.14159265, 31.4159265, 314.159265, 3141.59265, 3.14159265, 31.4159265, 314.159265, 3141.59265 };
		FigureFormatter.formatPrint(arr, 3);
	}

	public static void formatPrint(double[] numArr, int column) {
		for (int i = 0; i < numArr.length; i++) {
			String format = "%10.3f";
			System.out.printf(format, numArr[i]);
			if ((i + 1) % column == 0) {
				System.out.println();
			}
		}
	}

}
