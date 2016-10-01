package jpl.ch01.ex15;

import java.util.ArrayList;

public class Ex15_ArrayList implements ExtendsLookup {
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Object> values = new ArrayList<Object>();

	@Override
	public Object find(String name) {
		if (names.indexOf(name) == -1) {// 指定された要素がリストにない場合
			return null;
		} else {
			return values.get(names.indexOf(name));
		}
	}

	@Override
	public void add(String name, Object value) {// listの一番後ろに追加
		names.add(name);
		values.add(value);
	}

	@Override
	public void remove(String name) {
		if (names.indexOf(name) == -1) {// 指定された要素がリストにない場合
			// 何もしない
		} else {
			values.remove(names.indexOf(name));
			names.remove(names.indexOf(name));
		}
	}

}
