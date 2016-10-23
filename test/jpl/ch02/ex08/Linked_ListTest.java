package jpl.ch02.ex08;

import static org.junit.Assert.*;

import org.junit.Test;
public class Linked_ListTest {
	int[] testData = new int[] {123, 345, 567, 789};

	@Test
	public void test() {
		int i = 0;
		Linked_List list = new Linked_List(testData[i]);
		for(i = 1; i < testData.length; i++){
			list.add(testData[i]);
		}
		list.print();
		if (list.head.data == null) {
			fail();
		} else {
			i = 0;
			list.prev = list.head;
			assertEquals(testData[i], list.prev.data);
			while (list.prev.next != null) {
				list.prev = list.prev.next;
				i++;
				assertEquals(testData[i], list.prev.data);
			}
		}
	}

}
