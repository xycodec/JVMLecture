package com.xycode.jvm.Error;

import java.lang.reflect.Field;

import sun.misc.Unsafe;


/*
 * JVM args: 
 * 		-Xmx20M -XX:MaxDirectMemorySize=10M
 * 	
 */
public class DirectMemoryOOM {
	static final int _1MB=1024*1024;
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField=sun.misc.Unsafe.class.getDeclaredFields()[0];//反射机制,原则上UnSafe类只允许rt.jar中的类使用
		unsafeField.setAccessible(true);
		sun.misc.Unsafe unsafe=(Unsafe) unsafeField.get(null);
		int i=1;
		while(true) {
			unsafe.allocateMemory(_1MB);
			System.out.println(i++);
		}
		
	}

}
