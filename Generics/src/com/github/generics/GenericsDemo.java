package com.github.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * GenericsDemo demonstrates capabilities of generics with the simple examples.
 * 
 * @author nik
 **/
public class GenericsDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {		
		//since Java7,type inference
		List<String> list = new ArrayList();

		//generic collection iteration
		list.forEach(s -> System.out.println(s));

		//generic set
		Set<Integer> set = new HashSet();
		set.add(100);

		//generic class
		GenericInstanceFactory<HashMap> hashMapFactory = new GenericInstanceFactory(HashMap.class);
		HashMap hashMapInstance = hashMapFactory.createInstance();
		if(hashMapInstance instanceof HashMap) 
			System.out.println("HashMap instance created");
		GenericInstanceFactory<GenericsDemo> genericsDemoFactory = new GenericInstanceFactory(GenericsDemo.class);
		GenericsDemo genericDemoInstance = genericsDemoFactory.createInstance();
		if(genericDemoInstance instanceof GenericsDemo) System.out.println("GenericsDemo instance created");

		//generic method 
		String[] sArray = {"Instance1", "Instance2"};
		ArrayList<String> arrayList = (ArrayList<String>) GenericUtil.getCollectionFromArray(sArray, new ArrayList<String>());		
		arrayList.forEach(s -> System.out.println("ArrayList element - > " +s));
		
		//class Objects as type literals
		HashMap mapInstance = GenericInstanceFactory.createInstance(HashMap.class);
		if(mapInstance instanceof HashMap) 
			System.out.println("HashMap instance created through class object as type literral");
		
		HashSet setInstance = GenericInstanceFactory.createInstance(HashSet.class);
		if(setInstance instanceof HashSet) 
			System.out.println("HashSet instance created through class object as type literral");
		
		//wildcards
		List<Object> objectList = Arrays.asList("String 1", 10, "String 2", 90.50,true,10000);
		GenericUtil.genericListIteration(objectList);		
		List<Integer> intergerList = Arrays.asList(100,200);
		GenericUtil.genericRestrictiveListIteration(intergerList);
	}
}