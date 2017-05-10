package jpl.ch20.ex09;


import org.junit.Test;

public class FileDataTest {

	@Test
	public void test() {
		FileData fileData = new FileData("/Users/fujimuranatsumi/Documents/attrData.txt");
		fileData.printInfo();
	}

}
