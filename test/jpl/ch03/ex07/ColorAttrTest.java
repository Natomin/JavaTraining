package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	@Test
	public void test() {//equalメソッドのtest
		ColorAttr color1 = new ColorAttr("red", 100);
		ColorAttr color2 = new ColorAttr("green", 200);
		assertFalse(color1.equals(color2));
	}
	@Test
	public void test2() {//equalメソッドのtest
		ColorAttr color1 = new ColorAttr("red", 100);
		ColorAttr color2 = new ColorAttr("red", 100);
		assertTrue(color1.equals(color2));
	}
	
	@Test
	public void test3() {//hashCodeメソッドのtest
		ColorAttr color1 = new ColorAttr("red", 100);
		ColorAttr color2 = new ColorAttr("red", 100);
		System.out.println(color1.hashCode());
		System.out.println(color2.hashCode());
	}
	


}
