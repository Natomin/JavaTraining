package jpl.ch01.ex15;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest {

	private void nullFindTest(ExtendsLookup list, String name1){
		assertNull(list.find(name1));
	}

	private void addTest(ExtendsLookup list, String name1, Object data1, String name2, Object data2) {
		list.add(name1, data1);
		list.add(name2, data2);
		assertEquals(data1, list.find(name1));
		assertEquals(data2, list.find(name2));
	}
	
	private void removeTest(ExtendsLookup list, String name1, Object data1){
		list.add(name1, data1);
		assertEquals(data1, list.find(name1));
		list.remove(name1);
		assertNull(list.find(name1));		
	}
	@Test
	public void nullFindTest_Arr(){
		Ex15_ArrayList arrList = new Ex15_ArrayList();
		String name1 = "id1";
		nullFindTest(arrList, name1);
	}
	
	@Test
	public void addTest_Arr(){
		Ex15_ArrayList arrList = new Ex15_ArrayList();
		String name1 = "id1";
		Object data1 = 12345;
		String name2 = "id2";
		Object data2 = 56789;
		addTest(arrList, name1, data1, name2, data2);
	}
	
	@Test
	public void removeTest_Arr(){
		Ex15_ArrayList arrList = new Ex15_ArrayList();
		String name1 = "id1";
		Object data1 = 12345;
		removeTest(arrList, name1, data1);
	}
	@Test
	public void nullFindTest_Hash(){
		Ex15_HashMap hashMap = new Ex15_HashMap();
		String name1 = "id1";
		nullFindTest(hashMap, name1);
	}
	
	@Test
	public void addTest_Hash(){
		Ex15_HashMap hashMap = new Ex15_HashMap();
		String name1 = "id1";
		Object data1 = 12345;
		String name2 = "id2";
		Object data2 = 56789;
		addTest(hashMap, name1, data1, name2, data2);
	}
	
	@Test
	public void removeTest_Hash(){
		Ex15_HashMap hashMap = new Ex15_HashMap();
		String name1 = "id1";
		Object data1 = 12345;
		removeTest(hashMap, name1, data1);
	}
}
