package jpl.ch04.ex03;

public class Node {
	public Object data;
	public Node next;

	public Node(Object data) {
		this.data = data;
	}

	public String toString() {
		String desc = "data = " + data;
		return desc;
	}

}
