package com.github.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericsDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {		
		//since Java7,type inference
		List<String> list = new ArrayList();

		//collection iteration
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
		ArrayList<String> arrayList = (ArrayList<String>) GenericInstanceFactory.getCollectionFromArray(sArray, new ArrayList<String>());		
		arrayList.forEach(s -> System.out.println("ArrayList element - > " +s));
	}
}