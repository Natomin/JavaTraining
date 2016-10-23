package jpl.ch01.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		Point point = new Point();
		double x = 1;
		double y = 2;
		point.setPoint(x, y);
		assertEquals(x, point.x, 1e10);
		assertEquals(y, point.y, 1e10);
	}

}
