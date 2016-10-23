package jpl.ch02.ex11;

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
		System.out.println("test" + list);
	}

}
