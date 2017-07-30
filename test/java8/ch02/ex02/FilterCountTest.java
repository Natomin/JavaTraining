package java8.ch02.ex02;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FilterCountTest {

	@Test
	public void test() throws IOException {
		long count = new FilterCount().filterCount("./src/java8/ch02/ex01/alice.txt", 6);
		assertEquals(count, 5);
	}

}
