package jpl.ch02.ex16;
//リスト内の要素の数を返すメソッドをLinked_Listに追加する

/**
 * an Linked_List object define the data as a list,
 * where the data is arbitrary object.
 * @version 1.1
 * @author fujimuranatsumi
 * @since 1.0
 */
public class Linked_List {
	/**Hold the head node of the list*/
	private Node head = new Node(null);
	/** Hold the nodes in the list*/
	private Node prev = new Node(null);

	/**
	 * Create a new LinkedList with no data
	 */
	public Linked_List() {}

	/**
	 * Create a new linkedList with the given head data
	 * @param data arbitrary object
	 */
	public Linked_List(Object data) {
		this();
		Node node = new Node(data);
		head.data = node.data;
	}

	/**
	 * Return the number of elements in this list
	 */
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
	
	/**
	 * Add data to the list
	 * @param data The new data for the List node
	 */
	public void add(Object data) {
		Node node = new Node(data);
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

	/**
	 * Return a string of the form data = (<code>data</code>)
	 */
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
	
	/**Output elements of the list in order*/
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


	/** Return the head node of the list*/
	public Node getHead() {
		return head;
	}
	

	/** Returns the node pointed to by the prev of the list.*/
	public Node getPrev() {
		return prev;
	}
	
	/**
	 * Set the node pointed to by the prev of the list.
	 * @param prev new node pointed to by the prev
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
