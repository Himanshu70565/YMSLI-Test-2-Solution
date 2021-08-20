package com.singleton.enumsolution;

enum Singleton {
	INSTANCE;
}

public class DemoEnumSingleton {
	public static void main(String[] args) {
		System.out.println(Singleton.INSTANCE.hashCode());
	}
}
