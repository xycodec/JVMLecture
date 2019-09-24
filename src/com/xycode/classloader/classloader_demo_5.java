package com.xycode.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class classloader_demo_5 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//����ǰ�Ƚ���ǰ�������ɵ�my_object.classɾ��,����my_object����AppClassLoader����
		//�ɴ�,myExtClassLoader_1,myExtClassLoader_2���γ����������ռ�
		MyExtClassLoader myExtClassLoader_1=new MyExtClassLoader("C:/Users/xycode/Documents/WorkSpace/");
		MyExtClassLoader myExtClassLoader_2=new MyExtClassLoader("C:/Users/xycode/Documents/WorkSpace/");
		
		Class<?> c1=myExtClassLoader_1.loadClass("com.xycode.classloader.my_object");
		Class<?> c2=myExtClassLoader_2.loadClass("com.xycode.classloader.my_object");
		
		System.out.println(c1.getClassLoader());//MyExtClassLoader
		System.out.println(c1.getClassLoader().getClass().getClassLoader());//AppClassLoader
		Object o1=c1.newInstance();
		Object o2=c2.newInstance();
		Method method=c1.getMethod("setObject", Object.class);
		method.invoke(o1, o2);
	}

}
