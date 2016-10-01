package jpl.ch01.ex15;

public interface ExtendsLookup extends Lookup{
	/**
	 * nameとvalueを関連付けてデータを追加する
	 * @param name
	 * @param value
	 */
	void add(String name, Object value);
	/**
	 * nameと関連付いているデータを削除する
	 * @param name
	 */
	void remove(String name);

}
