package jpl.ch02.ex14;
//目視で確認
import org.junit.Test;

public class Linked_ListTest {
	int[] testData = new int[] { 123, 345, 567, 789 };
	@Test
	public void test() {
		Linked_List list = new Linked_List();
		for (int i = 0; i < testData.length; i++) {
			list.add(testData[i]);
		}
		
		for (int i = 0; i < testData.length; i++) {
			System.out.println(testData[i]);
		}
		System.out.println("");
		list.print();
	}

}
