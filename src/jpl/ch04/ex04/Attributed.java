package jpl.ch04.ex04;

public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	boolean equals(Attr attr);
	java.util.Iterator<Attr> attrs();
}
