package jpl.ch01.ex15;

import java.util.HashMap;
import java.util.Map;

public class Ex15_HashMap implements ExtendsLookup {
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public Object find(String name) {
		if (map.get(name) == null) {
			return null;
		} else {
			return map.get(name);
		}
	}

	@Override
	public void add(String name, Object value) {
		map.put(name, value);

	}

	@Override
	public void remove(String name) {
		map.remove(name);

	}
}
