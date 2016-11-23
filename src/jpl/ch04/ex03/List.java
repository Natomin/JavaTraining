package jpl.ch04.ex03;

public interface List extends Cloneable{
	public void add(Object data);
	public void changeData(int idx, Object data);
	public int nodeNum();
	public Linked_List clone();
	public String toString();
	public void print();
	
}
