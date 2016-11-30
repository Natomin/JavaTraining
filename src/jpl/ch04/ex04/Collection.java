package jpl.ch04.ex04;

public interface Collection {
	
	int hashCode();
	void clear();
	boolean containsAll();
	boolean equals(Object abj);
	boolean isEmpty();
	boolean removeAll(Collection c);
	int size();
	Object[] toArray();
}
