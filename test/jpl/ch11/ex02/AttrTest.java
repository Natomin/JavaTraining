package jpl.ch11.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttrTest {

	@Test
	public void test() {
		Attr<Integer> attr = new Attr<Integer>("a", 26);
		assertTrue(attr.getValue() instanceof Integer);
	}
	@Test
	public void test2() {
		Attr<String> attr = new Attr<String>("a", "26");
		assertTrue(attr.getValue() instanceof String);
	}

}
