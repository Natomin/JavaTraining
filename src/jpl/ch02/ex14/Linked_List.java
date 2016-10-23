package jpl.ch02.ex14;

//Linked_Listクラスのフィールドをprivateに変更して、フィールドに対するアクセッサーメソッドを追加する。
//どのフィールドが変更を許すメソッドを持ち、どのフィールドが持つべきではないか検討する。
public class Linked_List {
	private Node head = new Node(null);
	private Node prev = new Node(null);

	public Linked_List() {}
	public Linked_List(Object data) {
		this();
		Node node = new Node(data);
		head.data = node.data;
	}
	
	public Node getHead() {//listの先頭の管理は常にクラスの中でされるべきで、外から変更可能であるべきではないのでsetメソッドは不要
		return head;
	}
	
	public Node getPrev() {
		return prev;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
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

}
