package jpl.ch02.ex16;

/**
 * @version 1.1
 * @author fujimuranatsumi
 * @since 1.0
 */
public class Node {
	
	/**The node name*/
	public Object data;
	/**The node data */
	public Node next;

	/**
	 * Create a new Node with the given data
	 * @param data arbitrary object
	 */
	public Node(Object data) {
		this.data = data;
	}

	/**Return a string of the form data = <code>data</code>*/
	public String toString() {
		String desc = "data = " + data;
		return desc;
	}

}
