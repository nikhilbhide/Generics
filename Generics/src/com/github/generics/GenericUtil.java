package com.github.generics;

import java.util.Collection;
import java.util.List;

public class GenericUtil {	
	
	/**
	 * Instantiates {@link GenericUtil}. Private to prevent instantiation.
	 */
	private GenericUtil() {throw new AssertionError("Instantiating Util Class");}
	
	/**
	 * This method creates collection from array. T is used as type of array and collection.
	 * Compiler deduces type of T based on parameter passed to method.
	 *  
	 * @param array of generic type T
	 * @param collection of generic type T
	 * @return collection of generic type T populated with values retreived from array of generic type T
	 **/
	public static <T> Collection<T> getCollectionFromArray(T[] arrayInstance, Collection<T> collectionInstance) throws InstantiationException, IllegalAccessException {
		for (T e:arrayInstance) {
			collectionInstance.add(e);
		}
		return collectionInstance;
	}	

	/**
	 * This method iterates through the list which is passed as a parameter.
	 * List is typed to unknown type as generic wild card operator is used. 
	 * This method is used to read from generic collection.
	 *  
	 * @param List typed to unknown type
	 **/
	public static void genericListIteration(List<?> list) {
		System.out.println("This is generic iterator");
		list.forEach(e->System.out.println(e));
	}
	
	/**
	 * This method iterates through the list which is type to Interger type.
	 * This method is used to read from integer list.
	 *  
	 * @param list of integers
	 **/
	public static void genericRestrictiveListIteration (List<? extends Integer> list) {
		System.out.println("This allows iteration of list intergers only");
		list.forEach(e->System.out.println(e));
	}
}
