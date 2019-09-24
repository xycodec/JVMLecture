package com.xycode.jvm.classInit;

public class ClassInit_Demo_1 {
	static class super_class{
		public static int value=123;
		public static final String final_string="super_class' final variable";
		static {
			System.out.println("superClass init!");
		}
	}
	
	static class sub_class extends super_class{
		public static int value2=1234;
		public static final String final_string2="sub_class' final variable";
		static {
			System.out.println("subClass init!");
		}
		
	}
	
	public static void main(String[] args) {
		/*
		 * 子类引用父类的静态变量(非final)不会导致子类的初始化，只会初始化父类
		 */
		//System.out.println(sub_class.value);
		
		/*
		 * new 类的数组，并不会导致类的初始化
		 */
		super_class[] s=new super_class[10];
		System.out.println(s.getClass().getSuperclass());
		/*
		 * 引用类的static final variable并不会导致类的初始化(前提:编译期能够确定其值),
		 * 因为final变量实际上是存储在ClassloadDemo_1类的常量池中的(是在ClassloadDemo_1.class文件中),
		 * 除此之外super_class与ClassloadDemo_1类之间没有任何关系了
		 */
		System.out.println(sub_class.final_string2);
	}

}
