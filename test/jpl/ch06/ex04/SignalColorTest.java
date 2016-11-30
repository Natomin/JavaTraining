package jpl.ch06.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignalColorTest {
	public String color(SignalColor signalColor){
		String color = null;
		switch (signalColor) {
		case RED:
			color = "red";
			return color;
		case YELLOW:
			color = "yellow";
			return color;
		case GREEN:
			color = "green";
			return color;
		default:
			break;
		}
		return color;
	}

	@Test
	public void test() {
		//getColorでオブジェクトが取り出せているか確認
		SignalColor color = SignalColor.RED.getColor();
		assertEquals(color.toString(), "RED");
		assertEquals(color(color), "red");
	}
	@Test
	public void test2() {
		//getColorでオブジェクトが取り出せているか確認
		SignalColor color = SignalColor.YELLOW.getColor();
		assertEquals(color.toString(), "YELLOW");
		assertEquals(color(color), "yellow");
	}
	@Test
	public void test3() {
		//getColorでオブジェクトが取り出せているか確認
		SignalColor color = SignalColor.GREEN.getColor();
		assertEquals(color.toString(), "GREEN");
		assertEquals(color(color), "green");
	}
	

}
