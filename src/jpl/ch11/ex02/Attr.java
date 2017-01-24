package jpl.ch11.ex02;
//Attrクラスをジェネリッククラスとして書き直す
public class Attr <E>{
	private final String name;
	private E value = null;
	
	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, E value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}
	public String toString(){
		return name + "='" + value + "'";
	}

}
