package jpl.ch03.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortHarnessTest {
	Student[] testData = {
			new Student("aaa", 160, 23),
			new Student("bbb", 150, 20),
			new Student("ccc", 140, 19),
			new Student("ddd", 130, 25),
			new Student("eee", 120, 30),
	};
	
	Student[] expectedData = {
			new Student("eee", 120, 30),
			new Student("ddd", 130, 25),
			new Student("aaa", 160, 23),
			new Student("bbb", 150, 20),
			new Student("ccc", 140, 19),
	};
	
	@Test
	public void test() {
		SortHarness harness = new SortHarness();
		harness.Sort(new StudentComparator(), testData);
		for(int i = 0; i < testData.length; i++){
			System.out.println(i + ":" + testData[i].toString());
			System.out.println(i + ":" + expectedData[i].toString());
			assertEquals(testData[i].getAge(), expectedData[i].getAge());
		}
		
	}

}
