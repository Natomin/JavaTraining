package jpl.ch09.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitTest {

	@Test
	public void test() {//ふつうの値
		Bit bit = new Bit();
		int x = 10;
		assertEquals(Integer.bitCount(x), bit.bitCount(x));
	}
	
	@Test
	public void test2() {//0
		Bit bit = new Bit();
		int x = 0;
		assertEquals(Integer.bitCount(x), bit.bitCount(x));
	}
	
	@Test
	public void test3() {//intの最大値
		Bit bit = new Bit();
		int x = 2147483647;
		assertEquals(Integer.bitCount(x), bit.bitCount(x));
	}
	
	@Test
	public void test4() {//intの最小値
		Bit bit = new Bit();
		int x = -2147483648;
		assertEquals(Integer.bitCount(x), bit.bitCount(x));
	}
	
	

}
