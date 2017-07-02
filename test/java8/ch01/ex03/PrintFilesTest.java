package java8.ch01.ex03;

import java.io.File;

import org.junit.Test;


public class PrintFilesTest {

	@Test
	public void test() {
		PrintFiles lambda = new PrintFiles();
		lambda.printDir(new File("./src/java8/ch01/ex02"), "java");
	}

}
