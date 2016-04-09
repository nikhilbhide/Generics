package com.github.generics;

/**
 * GenericsInstanceFactory is a instance factory that creates instances for generic types.
 * It uses either generic class or generic method to create the object.
 * 
 * @author nik
 **/
public class GenericInstanceFactory<T> {
	private Class myClass;
	
	/**
	 * Class constructor.
	 * A class whose instance is to be created is passed as an argument.
	 * 
	 * @param myClass The Class
	 **/
	public GenericInstanceFactory(Class myClass) {
		this.myClass = myClass;
	}
	
	/**
	 * This method creates instance of generic type of the GenericInstanceFactory created.
	 * Compiler deduces the type of object from the generic type of GenericInstanceFactory created. 
	 * 
	 * @return object of the generic type of the GenericInstanceFactory created.
	 **/	
	public T createInstance() throws InstantiationException, IllegalAccessException {
		return (T) this.myClass.newInstance();
	}
	
	
	/**
	 * This method creates instance of generic type the class passed as an input parameter.
	 * Class objects can be used as type specifications. Return parameter is deduced from the 
	 * generic type of class passed at run time. 
	 * 
	 * @param generic typed class object
	 * @return object of generic type of the class passed as an input parameter 
	 **/
	public static <T> T createInstance(Class<T> theClass) throws InstantiationException, IllegalAccessException {
		return theClass.newInstance();
	}	
}