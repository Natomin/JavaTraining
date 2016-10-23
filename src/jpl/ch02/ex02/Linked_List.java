package jpl.ch02.ex02;
//LinkedListクラスを作成する。Object型のフィールドと、リストの中で次のLinkedList要素への参照を持つ

public class Linked_List {
	public Node head = new Node(null);
	public Node prev = new Node(null);
	
	public void add(Object data){
		Node node = new Node(data);
		if(head.data == null){
			head.data = node.data;
		}else if(head.next == null){
			head.next = node;
		}else{
			prev = head;
			while(prev.next != null){
				prev = prev.next;
			}
			prev.next = node;
		}
	}
	
	public void print(){
		if(head.data == null){
			System.out.println("dataがありません");
		}else{
			prev = head;
			System.out.println(prev.data);
			while(prev.next != null){
				prev = prev.next;
				System.out.println(prev.data);
			}
		}
	}

}
