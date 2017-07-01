package jpl.ch22.ex04;

public class Attr {
	private final String name;
	private Object value = null;
	
	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	public String toString(){
		return name + "=" + value;
	}

}

