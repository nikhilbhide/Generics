package com.github.generics;

import java.util.Collection;


public class GenericInstanceFactory<T> {
	private Class myClass;
	public GenericInstanceFactory(Class myClass) {
		this.myClass = myClass;
	}
	
	public T createInstance() throws InstantiationException, IllegalAccessException {
		return (T) this.myClass.newInstance();
	}
	
	public static <T> Collection<T> getCollectionFromArray(T[] arrayInstance, Collection<T> collectionInstance) throws InstantiationException, IllegalAccessException {
		for (T e:arrayInstance) {
			collectionInstance.add(e);
		}
		return collectionInstance;
	}
}