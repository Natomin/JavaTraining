package jpl.ch20.ex04;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class LineOutputStreamTest {

	@Test
	public void stringTest() throws IOException {
		StringReader reader = new StringReader("test\nreadline");
		LineOutputStream lineStream = new LineOutputStream(reader);
		assertEquals("test\n", lineStream.readLine());
		assertEquals("readline", lineStream.readLine());
		lineStream.close();
	}
	
	@Test
	public void fileTest() throws IOException {
		FileReader reader = new FileReader("/Users/fujimuranatsumi/Documents/readline.txt");
		LineOutputStream lineStream = new LineOutputStream(reader);
		String c = lineStream.readLine();
		System.out.println(c);
		assertEquals("TestFile\r", c);
		c = lineStream.readLine();
		System.out.println(c);
		assertEquals("ReadLine\r", c);
		c = lineStream.readLine();
		System.out.println(c);
		assertEquals("LineOutputStream\r", c);
		lineStream.close();
	}

}
