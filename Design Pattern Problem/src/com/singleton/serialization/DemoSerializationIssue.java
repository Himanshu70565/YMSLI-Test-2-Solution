package com.singleton.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Singleton implements Serializable{
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
public class DemoSerializationIssue {
	public static void main(String[] args) {
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("serial.ser"));
			Singleton singleton=Singleton.getSingletonObject();
			System.out.println(singleton.hashCode());
			oos.writeObject(singleton);
			
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("serial.ser"));
			Singleton singleton2=(Singleton)ois.readObject();
			System.out.println(singleton2.hashCode()); //diff
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
