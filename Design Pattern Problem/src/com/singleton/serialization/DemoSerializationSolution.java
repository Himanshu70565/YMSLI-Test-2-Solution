package com.singleton.serialization;

import java.io.Serializable;

class SingletonSerializale implements Serializable{
	public static SingletonSerializale singleton = null;

	private SingletonSerializale() {
	}

	public static synchronized SingletonSerializale getSingleton() {
		if (singleton == null) {
			singleton = new SingletonSerializale();
		}
		return singleton;
	}
	
	
	protected Object readResolve() {
		return getSingleton();
	}
	
}
public class DemoSerializationSolution {
	
}
