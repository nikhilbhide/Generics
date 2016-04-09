package com.github.generics;

import java.util.HashMap;
import java.util.Map;

public class Container<K,T> {
	private Map<K,T> container = new HashMap();
	public T get(K key) {
		return container.get(key);
	}
	
	public void put(K key, T value) {
		container.put(key, value);
	}
}