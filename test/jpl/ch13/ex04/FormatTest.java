package jpl.ch13.ex04;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FormatTest {

	@Test
	public void test() {
		Format format = new Format();
		String data = "Integer 10" + "\n"
				+ "Integer 20" + "\n"
				+ "Integer 30" + "\n";
		ArrayList<?> list = format.formatConversion(data);
		for (int i = 0 ; i < list.size() ; i++){
		      int value = (int) list.get(i);
		      System.out.println(value);
		    }
//		fail("まだ実装されていません");
	}

}
