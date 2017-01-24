package jpl.ch12.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList list = new LinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.print();
		try {
			list.find("ddd");//listにないオブジェクトを検索
			fail();//例外がスローされずにこの行が実行されたら失敗
		} catch (ObjectNotFoundException e) {
			assertEquals(e.getMessage(), "No data \"ddd\" is found");
		}	
	}

}
