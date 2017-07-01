package jpl.ch22.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class ObservedAttributed extends Observable implements Attributed{
	private Map<String, Attr> attrMap = new HashMap<>();

	@Override
	public void add(Attr newAttr) {
		attrMap.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(attrMap);
	}

	@Override
	public Attr find(String attrName) {
		return attrMap.get(attrName);
	}

	@Override
	public Attr remove(String attrName) {
		Attr attr = attrMap.get(attrName);
		attrMap.remove(attrName);
		setChanged();
		notifyObservers(attrMap);
		return attr;
	}

	@Override
	public Iterator<Attr> attrs() {
		return attrMap.values().iterator();
	}
	

}
