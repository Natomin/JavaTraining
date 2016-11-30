package jpl.ch06.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignalColorTest {
	@Test
	public void test() {
		assertEquals(SignalColor.RED.toString(), "RED");
	}
	@Test
	public void test2() {
		assertEquals(SignalColor.YELLOW.toString(), "YELLOW");
	}
	@Test
	public void test3() {
		assertEquals(SignalColor.GREEN.toString(), "GREEN");
	}

}
