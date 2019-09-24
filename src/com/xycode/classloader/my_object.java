package com.xycode.classloader;

public class my_object {
	private my_object o;
	static {
		System.out.println("----> "+my_object.class+" initialized,this is static code");
	}
	
	public void setObject(Object o) {
		this.o=(my_object) o;
		System.out.println("cast!");
	}
	
	public static void main(String[] args) {
		
	}

}
