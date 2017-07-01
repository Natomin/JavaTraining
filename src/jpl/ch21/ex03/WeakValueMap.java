package jpl.ch21.ex03;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeakValueMap<K, V> implements Map<K, V>{
	private HashMap<K, WeakReference<V>> weakValueMap = new HashMap<K, WeakReference<V>>();
	
	@Override
	public int size() {
		return weakValueMap.size();
	}

	@Override
	public boolean isEmpty() {
		return weakValueMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return weakValueMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return weakValueMap.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return (V) weakValueMap.get(key);
	}

	@Override
	public V put(K key, V value) {
		WeakReference<V> weakValue = new WeakReference<V>(value);
		if(weakValueMap.containsKey(key)){
			WeakReference<V> oldValue = weakValueMap.get(key);
			weakValueMap.put(key, weakValue);
			return (V) oldValue;
		}else{
			weakValueMap.put(key, weakValue);
			return null;
		}
	}

	@Override
	public V remove(Object key) {
		if(weakValueMap.containsKey(key)){
			WeakReference<V> oldValue = weakValueMap.get(key);
			weakValueMap.remove(key);
			return (V) oldValue;
		}else{
			return null;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		HashMap<K, WeakReference<V>> newMap = new HashMap<>();

		
//		weakValueMap.putAll(m);
	}

	@Override
	public void clear() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Set<K> keySet() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
