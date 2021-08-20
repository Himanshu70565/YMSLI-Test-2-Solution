package com.singleton.eager;
class Singleton{
	
	public static Singleton singleton=new Singleton();
	
	private Singleton() {
	}
	
	public static Singleton getSingleton() {
		return singleton;
	}
}
public class DemoSingleton {
	public static void main(String[] args) {
		Singleton singelton1=Singleton.getSingleton();
		Singleton singelton2=Singleton.getSingleton();
		
		//both are same but eager Initilaztion is not preferred
		System.out.println(singelton1.hashCode()+" "+singelton2.hashCode());
	}
}
