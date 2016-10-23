package jpl.ch02.ex11;

public class Node {

	public Object data;
	public Node next;

	public Node(Object data) {
		this.data = data;
	}
	
	public String toString(){
		String desc = "data = " + data;
		return desc;
	}

}
