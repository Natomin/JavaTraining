package java8.ch02.ex01;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ParallelForLoopTest {

	@Test
	public void test() throws IOException, InterruptedException {
		int result = new ParallelForLoop().countLongWord("./src/java8/ch02/ex01/alice.txt", 12);
		assertEquals(result, 2);
	}

}
