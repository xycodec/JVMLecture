package com.xycode.classloader;

public class classloader_demo_4 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyExtClassLoader myExtClassLoader_1=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		MyExtClassLoader myExtClassLoader_2=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		
		Class<?> c1=myExtClassLoader_1.loadClass("com.xycode.classloader.my_object");
		Class<?> c2=myExtClassLoader_2.loadClass("com.xycode.classloader.my_object");
		System.out.println(c1==c2);//输出为true,说明c1,c2是一个东西
		//原因是:com.xycode.classloader.my_object在classpath中,c1,c2都是有AppClassLoader加载的,
		//由loadClass()的特性,所以c1,c2是一个东西
		
		myExtClassLoader_1.setLocation("C:/Users/xycode/git/MultiThread_demo/MultiThread_demo/bin/");
		myExtClassLoader_2.setLocation("C:/Users/xycode/git/MultiThread_demo/MultiThread_demo/bin/");
		c1=myExtClassLoader_1.loadClass("com.xycode.pro.CacheTest");
		c2=myExtClassLoader_2.loadClass("com.xycode.pro.CacheTest");
		System.out.println(c1==c2);//输出为false
		//原因:因为加载的路径不在classpath中,所以实际上是由myExtClassLoader_1,myExtClassLoader_2分别加载的,
		//故c1,c2不是一个东西

	}

}
