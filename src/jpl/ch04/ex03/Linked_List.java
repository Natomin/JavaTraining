package jpl.ch04.ex03;
//LinkedListクラスを実装クラスとインタフェースを使用して書き直す（LinkedListを使用してメソッドを実装）
//LinkedListクラスはインターフェースであるべきか
//→複数の実装ができるのでインタフェースであるべき
import java.util.LinkedList;

public class Linked_List implements List{
	LinkedList<Node> list = new LinkedList<Node>();

	@Override
	public void add(Object data) {
		list.add(new Node(data));	
	}

	@Override
	public void changeData(int idx, Object data) {
		list.set(idx, new Node(data));
	}

	@Override
	public int nodeNum() {
		return list.size();
	}

	public Linked_List clone() {
		Linked_List clone = null;
		try {
			clone = (Linked_List) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
		return clone;
	}

	@Override
	public void print() {
		System.out.println(list.toString());
	}

}
