package com.xycode.jvm.classInit;

import java.util.UUID;

public class ClassInit_Demo_2 {

	public static void main(String[] args) {
		System.out.println(subClass.uuid);
		System.out.println();
		System.out.println(subClass2.s);
	}

}

class subClass{
	public static final String uuid=UUID.randomUUID().toString();
	
	static {
		System.out.println("subClass static code");
	}
}

class subClass2{
	public static final String s="ss";
	
	static {
		System.out.println("subClass2 static code");
	}
}

