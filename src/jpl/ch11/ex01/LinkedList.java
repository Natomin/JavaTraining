package jpl.ch11.ex01;
//ジェネリッククラスにする

public class LinkedList <E>{
	private Node<E> head = new Node<E>(null);
	private Node<E> prev = new Node<E>(null);

	public LinkedList() {}
	public LinkedList(E data) {
		this();
		Node<E> node = new Node<E>(data);
		head.data = node.data;
	}

	public int nodeNum(){
		int nodeNum = 0;
		if (head.data == null) {
		} else {
			prev = head;
			nodeNum++;
			while (prev.next != null) {
				prev = prev.next;
				nodeNum++;
			}
		}
		return nodeNum;
	}
	
	public void add(E data) {
		Node<E> node = new Node<E>(data);
		if (head.data == null) {
			head.data = node.data;
		} else if (head.next == null) {
			head.next = node;
		} else {
			prev = head;
			while (prev.next != null) {
				prev = prev.next;
			}
			prev.next = node;
		}
	}

	public String toString() {
		String desc;
		if (head.data == null) {
			desc = "data = (null)";
		} else {
			prev = head;
			desc = " data = " + "(" + prev.data + ")";
			while (prev.next != null) {
				prev = prev.next;
				desc = desc + "(" + prev.data + ")";
			}
		}
		return desc;
	}
	
	public void print() {
		if (head.data == null) {
			System.out.println("dataがありません");
		} else {
			prev = head;
			System.out.println(prev.data);
			while (prev.next != null) {
				prev = prev.next;
				System.out.println(prev.data);
			}
		}
	}

	public Node<E> getHead() {
		return head;
	}
	
	public Node<E> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

}
