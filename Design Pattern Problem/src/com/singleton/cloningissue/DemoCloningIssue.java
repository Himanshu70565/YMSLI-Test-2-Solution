package com.singleton.cloningissue;

class Singleton implements Cloneable{
	public static Singleton singleton = null;

	private Singleton() {
	}

	public static synchronized Singleton getSingletonObject() {
		if (singleton == null) {
			if(singleton==null) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
}

public class DemoCloningIssue {
	public static void main(String[] args) {
		Singleton singleton=Singleton.getSingletonObject();
		System.out.println(singleton.hashCode());
		
		
		//Makes a clone
//		Singleton singleton2 =(Singleton) singleton.clone(); 
//		System.out.println(singleton2.hashCode()); 
		
		try {
			singleton.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	
	}
}
