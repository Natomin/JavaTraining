package jpl.ch20.ex07;


import java.io.IOException;

import org.junit.Test;

public class AttrTest {

	@Test
	public void test() throws IOException {
		int value = 200;
		Attr attr = new Attr("testName", value);
		attr.outputData("/Users/fujimuranatsumi/Documents/attrData.txt");
	}
	
	@Test
	public void test2() throws IOException {
		Attr attr = new Attr("/Users/fujimuranatsumi/Documents/attrData.txt");
		System.out.println(attr.toString());
	}

}
