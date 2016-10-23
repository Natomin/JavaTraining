package jpl.ch02.ex16;
//リスト内の要素の数を返すメソッドをLinked_Listに追加する
public class Linked_List {
	private Node head = new Node(null);
	private Node prev = new Node(null);

	public Linked_List() {}
	public Linked_List(Object data) {
		this();
		Node node = new Node(data);
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

	public Node getHead() {
		return head;
	}
	
	public Node getPrev() {
		return prev;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
