package java8.ch01.ex02;

import java.io.File;
import org.junit.Test;

public class PrintDirTest {

	@Test
	public void testLambda() {
		PrintDir_Lambda lambda = new PrintDir_Lambda();
		lambda.printDir(new File(".//"));
		System.out.println();
	}
	
	@Test
	public void testMethod() {
		PrintDir_Lambda lambda = new PrintDir_Lambda();
		lambda.printDir(new File("../"));
		System.out.println();
	}

}
