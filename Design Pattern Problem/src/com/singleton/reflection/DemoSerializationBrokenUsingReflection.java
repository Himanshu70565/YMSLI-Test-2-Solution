package com.singleton.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton {

	public static Singleton singleton = null;

	private Singleton() {
	}

	public static synchronized Singleton getSingletonObject() {
		// double locking policy
		if (singleton == null) {
			if (singleton == null) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}
}

public class DemoSerializationBrokenUsingReflection {
	public static void main(String[] args) {

		Singleton singleton1 = Singleton.getSingletonObject();
		try {
			Class<?> clazz = Class.forName("com.singleton.reflection.Singleton");
			Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
			declaredConstructors[0].setAccessible(true);
			Singleton singleton2 = (Singleton) declaredConstructors[0].newInstance();
			System.out.println(singleton1.hashCode() + " " + singleton2.hashCode());

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
