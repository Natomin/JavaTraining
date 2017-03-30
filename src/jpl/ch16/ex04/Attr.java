package jpl.ch16.ex04;

@MyAnnotation
public class Attr {
	@MyAnnotation
	private final String name;
	private Object value = null;
	
	@MyAnnotation
	public Attr(String name) {
		this.name = name;
	}

	@MyAnnotation
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
		return name + "='" + value + "'";
	}


}
