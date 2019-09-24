package com.xycode.GC;

/**
 * jvm args:
 * 		-verbose:gc
 * @author xycode
 *
 */

public class GC_demo_4 {

	public static void main(String[] args) {
		{//将palceholder的作用域限制在{ }中
			byte[] palceholder=new byte[64*1024*1024];
		}
		int a=0;//重新引用局部变量表
		System.gc();
	}

}
