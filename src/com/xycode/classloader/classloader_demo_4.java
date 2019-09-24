package com.xycode.classloader;

public class classloader_demo_4 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyExtClassLoader myExtClassLoader_1=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		MyExtClassLoader myExtClassLoader_2=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		
		Class<?> c1=myExtClassLoader_1.loadClass("com.xycode.classloader.my_object");
		Class<?> c2=myExtClassLoader_2.loadClass("com.xycode.classloader.my_object");
		System.out.println(c1==c2);//���Ϊtrue,˵��c1,c2��һ������
		//ԭ����:com.xycode.classloader.my_object��classpath��,c1,c2������AppClassLoader���ص�,
		//��loadClass()������,����c1,c2��һ������
		
		myExtClassLoader_1.setLocation("C:/Users/xycode/git/MultiThread_demo/MultiThread_demo/bin/");
		myExtClassLoader_2.setLocation("C:/Users/xycode/git/MultiThread_demo/MultiThread_demo/bin/");
		c1=myExtClassLoader_1.loadClass("com.xycode.pro.CacheTest");
		c2=myExtClassLoader_2.loadClass("com.xycode.pro.CacheTest");
		System.out.println(c1==c2);//���Ϊfalse
		//ԭ��:��Ϊ���ص�·������classpath��,����ʵ��������myExtClassLoader_1,myExtClassLoader_2�ֱ���ص�,
		//��c1,c2����һ������

	}

}
