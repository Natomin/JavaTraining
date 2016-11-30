package jpl.ch03.ex10;

public class Node implements Cloneable{
	public Object data;
	public Node next;

	public Node(Object data) {
		this.data = data;
	}
	
	public Node clone(){
		try {
			Node node = (Node)super.clone();
			return node;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
		
	}

	public String toString() {
		String desc = "data = " + data;
		return desc;
	}

}
