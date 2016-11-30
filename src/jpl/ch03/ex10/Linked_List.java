package jpl.ch03.ex10;

public class Linked_List implements Cloneable {
	private Node head = new Node(null);
	private Node prev = new Node(null);

	public Linked_List() {
	}

	public Linked_List(Object data) {
		this();
		Node node = new Node(data);
		head.data = node.data;
	}

	public Linked_List clone() {
		Linked_List list;
		try {
			list = (Linked_List) super.clone();
			int i = 0;
			if (head.data == null) {
			} else {
//				list.head = this.head.clone();
//				list.prev = list.head;
//				this.prev = this.head;
//				i++;
//				while (i < list.nodeNum()) {//テストが終わってくれない
//					this.prev = this.prev.next;
//					list.prev.next = this.prev.clone();
//					list.prev = list.prev.next;
//					i++;
//				}
			}
			return list;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	/**
	 *テスト用メソッド
	 *リストの最初のノードをリストの最後に移動するメソッド
	 */
	public void rotation(){
		Node end = new Node(null);
		int i = 0;
		if (head.data == null) {
		} else {
			prev = head;
			i++;
			while(i < this.nodeNum()){
				prev = prev.next;
				i++;
			}
			end = prev;
		prev = head;
		head = head.next;
		prev.next = null;
		end.next = prev;
		}
	}

	public void changeData(int idx, Object data) {
		Node node = new Node(data);
		int cnt = 0;
		prev = head;
		try {
			while (cnt < idx) {
				prev = prev.next;
				cnt++;
			}
			prev.data = node.data;
		} catch (NullPointerException e) {
			System.out.println("データがありません");
		}
	}

	public int nodeNum() {
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
			System.out.print(prev.data + "  ");
			while (prev.next != null) {
				prev = prev.next;
				System.out.print(prev.data + "  ");
			}
			System.out.println("");
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
