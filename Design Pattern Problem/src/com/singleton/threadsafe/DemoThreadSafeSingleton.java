package com.singleton.threadsafe;

class Singleton {

	public static Singleton singleton = null;

	private Singleton() {
	}

	public static synchronized Singleton getSingletonObject() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}

public class DemoThreadSafeSingleton {
	public static void main(String[] args) {

	}
}
