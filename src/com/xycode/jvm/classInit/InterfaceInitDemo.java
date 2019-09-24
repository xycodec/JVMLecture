package com.xycode.jvm.classInit;

/**
 * Interface的初始化与Class不同,引用子Interface的静态变量不会导致父Interface的初始化
 * 引用父Interface的静态变量也不会导致子Interface的初始化
 * 原因:因为Interface中的变量默认都是static final的,结论参见Class的结论
 * @author xycode
 *
 */
public class InterfaceInitDemo {
	public static void main(String[] args) {
		System.out.println(superImpl.b);// 在初始化一个类时，并不会先初始化它所实现的接口。
		System.out.println();
		System.out.println(subI.a);
		
	}
	
}

interface superI{
	public static Thread t=new Thread() {
		{
			System.out.println("superI Init");
		}
	};
	
}

interface subI extends superI{
	public static int a=10;
}


class superImpl implements superI{
	public static int b=20;
}



