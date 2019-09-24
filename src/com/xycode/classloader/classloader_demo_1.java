package com.xycode.classloader;

public class classloader_demo_1 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		//调用classLoader类的1oadclass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
		//但是使用Class.forName(),会导致类的初始化,因为它实际上是加载并new了一个对象
		Class<?> c1=Class.forName("java.lang.String");
		System.out.println(c1.getClassLoader());//null
		//说明java原生类型是由BootStrap ClassLoader加载的,
		//BootStrap ClassLoader负责加载JAVA_HOME/lib下和-Xbootclasspath参数指定的路径下的类
		//BootStrap ClassLoader只会加载名字符合规范的类库
		
//		ClassLoader.getSystemClassLoader().loadClass("com.xycode.classloader.my_object");
		
	
		Class<?> c2=Class.forName("com.sun.javafx.animation.TickCalculation");
		System.out.println(c2.getClassLoader());
		Class<?> c3=Class.forName("com.xycode.classloader.my_object");
		
		System.out.println(c3.getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@15db9742
		//说明自定义类是AppClassLoader加载的
	}

}
