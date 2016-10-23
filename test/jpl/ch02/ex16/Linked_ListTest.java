package jpl.ch02.ex16;

import static org.junit.Assert.*;
import org.junit.Test;

public class Linked_ListTest {
	int[] testData = new int[] {123, 345, 567, 789};

	@Test
	public void test() {
		Linked_List list = new Linked_List();
		for(int i = 0; i < testData.length; i++){
			list.add(testData[i]);
		}
		System.out.println("nodeNum = " + list.nodeNum());
		assertEquals(testData.length, list.nodeNum());
	}
}
