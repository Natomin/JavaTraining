package java8.ch02.ex03;


import java.io.IOException;

import org.junit.Test;

public class ExecutionSpeedTest {

	@Test
	public void test() throws IOException {
		long beforeTime = System.nanoTime();
		new ExecutionSpeed().countLongWords("./src/java8/ch02/ex01/alice.txt", 12);
		long afterTime = System.nanoTime();
		System.out.println("not parallel: " + (afterTime - beforeTime));
		
		beforeTime = System.nanoTime();
		new ExecutionSpeed().countLongWordsParallel("./src/java8/ch02/ex01/alice.txt", 12);
		afterTime = System.nanoTime();
		System.out.println("    parallel: " + (afterTime - beforeTime));
	}
	


}
