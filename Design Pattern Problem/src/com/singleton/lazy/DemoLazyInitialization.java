package com.singleton.lazy;

class Singleton {

	public static Singleton singleton = null;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}

public class DemoLazyInitialization {
	public static void main(String[] args) {
		Singleton singleton=Singleton.getSingleton();
		Singleton singleton2=Singleton.getSingleton();
		
		//It has a problem of thread safety
		System.out.println(singleton.hashCode()+" "+singleton2.hashCode());
		
		
	}
}
