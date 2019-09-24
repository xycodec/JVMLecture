package com.xycode.classloader;

public class classloader_demo_3 {
	public static void main(String[] args) throws ClassNotFoundException {
		MyExtClassLoader myExtClassLoader=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		//loadClass()会调用findClass()方法,但这里却不会调用自定义的findClass
		Class<?> c1=myExtClassLoader.loadClass("com.xycode.classloader.my_object");//static code没有执行,说明只是加载了字节码,而没有初始化对象
		System.out.println(c1.getClassLoader());//AppClassLoader
		//可以看出实际上进行加载工作的是AppClassLoader
		System.out.println(c1.hashCode());
		
		
		Class<?> c2=myExtClassLoader.loadClass("com.xycode.classloader.my_object");//static code没有执行,说明只是加载了字节码,而没有初始化对象
		System.out.println(c2.getClassLoader());//MyExtClassLoader
		System.out.println(c2.getClassLoader());//AppClassLoader
		System.out.println(c2.hashCode());
		/**
		 * 注意,对于一个类加载器来说,如果已经加载过一个class文件,后续再次调用就不会再次加载了,会直接将之前加载的结果返回
		 * (这里说的加载不是指当前加载器真正地加载,如果实际的加载已经由父类加载器加载了,
		 *   此时由于双亲委派模型,也不会重复加载,就会直接返回已加载的结果)
		 *   这点可以从打印class的hashcode可以看出,c1,c2的hashcode是一致的
		 */
	}
}
