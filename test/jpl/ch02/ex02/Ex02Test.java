package jpl.ch02.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex02Test {

	@Test
	public void test() {
		Linked_List list = new Linked_List();
		list.add(123);
		list.add(345);
		list.add(567);
		list.add(789);
		list.print();
		
	}

}
