package jpl.ch12.ex01;
//LinkedListクラスに対するObjectNotFoundExceptionクラスを作成する。
//リスト中のオブジェクトを探すfindメソッドを追加する。（要求されたオブジェクトを持つNodeを返すか、なければその例外を投げる）
//オブジェクトが発見されなかったときにnullを返すよりも例外をスローする方が好まれる理由は？
//->nullを返す場合：メソッドを使うひとは戻り値がnullがどうかを検査する必要がある。検査せずに使い、nullが返ってきた場合
// NullPointerExceptionが発生してしまう可能性がある。
//->例外をスローする場合：メソッドを使うひとは、例外が発生したときの処理を書かないと使用できないため、書き忘れることがない。
public class LinkedList {
	private Node head = new Node(null);
	private Node prev = new Node(null);

	public LinkedList() {}
	public LinkedList(Object data) {
		this();
		Node node = new Node(data);
		head.data = node.data;
	}
	
	public Node find(Object data) throws ObjectNotFoundException{
		if (head.data == null) {
			System.out.println("dataがありません");
		} else {
			prev = head;
			if(prev.data == data){
				return prev;
			}
			while (prev.next != null) {
				prev = prev.next;
				if(prev.data == data){
					return prev;
				}
			}
		}
		throw new ObjectNotFoundException(data);
		
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
