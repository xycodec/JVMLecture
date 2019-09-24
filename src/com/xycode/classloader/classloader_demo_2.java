package com.xycode.classloader;

public class classloader_demo_2 {
	/*
	 * 数组类的类对象不是由类加载器创建的，而是根据Java Runtime的自动创建的。
	 * 数组类的类加载器与元素类型的类加载器相同。
	 * 如果元素类型是primitive type(int,float,double,short,long,boolean)，则数组类没有类加载器。
	 */
	public static void main(String[] args) {
		String[] s=new String[10];
		System.out.println(s.getClass().getClassLoader());//null,数组的加载器与元素类型的类加载器一致
		
		my_object[] o=new my_object[10];
		System.out.println(o.getClass().getClassLoader());//AppClassLoader
		
		int[] i=new int[10];
		System.out.println(i.getClass().getClassLoader());//null
		//这个null并不是表示bootstrap ClassLoader,而是表示没有类加载器,因为int是primitive type
	}

}
