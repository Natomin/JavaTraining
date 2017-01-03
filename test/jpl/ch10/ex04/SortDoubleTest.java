package jpl.ch10.ex04;

import org.junit.Test;
import jpl.ch03.ex11.SortDouble;
import jpl.ch03.ex11.SortMetrics;

public class SortDoubleTest {

	double[] testData = {
			0.3, 1.3e-2, 7.9, 3.17
	};

	@Test
	public void test() {
		SortDouble bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for(int i = 0; i < testData.length; i++){
			System.out.println("\t" + testData[i]);
		}
	}
}
