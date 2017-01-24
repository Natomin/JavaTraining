package jpl.ch11.ex01;


import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.print();
	}
	
	@Test
	public void test2() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.print();
	}

}
