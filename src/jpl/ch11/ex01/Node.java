package jpl.ch11.ex01;


public class Node<E> {
	public E data;
	public Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public String toString() {
		String desc = "data = " + data;
		return desc;
	}

}
