package jpl.ch03.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Linked_ListTest {

	@Test
	public void test() {
		Linked_List list = new Linked_List(100);
		list.add(200);
		list.add(300);
		
		Linked_List listClone = list.clone();//クローン作成
		//listとlistCloneのデータが一致しているか確認
		assertEquals(list.toString(), listClone.toString());

		//clone側から参照オブジェクトのデータ書き換え
		listClone.changeData(1, 500);
		//list側から変更が見えるか確認
		assertEquals(list.toString(), listClone.toString());
		
		//list側から参照オブジェクトのデータ書き換え
		list.changeData(1, 800);
		//clone側から変更が見えるか確認
		assertEquals(list.toString(), listClone.toString());
		
		//listの参照を変更
		list.rotation();
		System.out.println(list.toString());
		System.out.println(listClone.toString());
		
		list.rotation();
		System.out.println(list.toString());
		System.out.println(listClone.toString());
		
		list.rotation();
		System.out.println(list.toString());
		System.out.println(listClone.toString());
		//clone側には影響しないことを確認
	}

}
