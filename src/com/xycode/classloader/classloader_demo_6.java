package com.xycode.classloader;

public class classloader_demo_6 {

	public static void main(String[] args) {
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println();
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println();
		System.out.println(System.getProperty("java.class.path"));//当前工程的classpath
		
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.class.getClassLoader());
	}

}
