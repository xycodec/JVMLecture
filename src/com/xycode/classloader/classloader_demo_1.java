package com.xycode.classloader;

public class classloader_demo_1 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		//����classLoader���1oadclass��������һ���࣬�����Ƕ��������ʹ�ã����ᵼ����ĳ�ʼ��
		//����ʹ��Class.forName(),�ᵼ����ĳ�ʼ��,��Ϊ��ʵ�����Ǽ��ز�new��һ������
		Class<?> c1=Class.forName("java.lang.String");
		System.out.println(c1.getClassLoader());//null
		//˵��javaԭ����������BootStrap ClassLoader���ص�,
		//BootStrap ClassLoader�������JAVA_HOME/lib�º�-Xbootclasspath����ָ����·���µ���
		//BootStrap ClassLoaderֻ��������ַ��Ϲ淶�����
		
//		ClassLoader.getSystemClassLoader().loadClass("com.xycode.classloader.my_object");
		
	
		Class<?> c2=Class.forName("com.sun.javafx.animation.TickCalculation");
		System.out.println(c2.getClassLoader());
		Class<?> c3=Class.forName("com.xycode.classloader.my_object");
		
		System.out.println(c3.getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@15db9742
		//˵���Զ�������AppClassLoader���ص�
	}

}
