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
		 * �������ø���ľ�̬����(��final)���ᵼ������ĳ�ʼ����ֻ���ʼ������
		 */
		//System.out.println(sub_class.value);
		
		/*
		 * new ������飬�����ᵼ����ĳ�ʼ��
		 */
		super_class[] s=new super_class[10];
		System.out.println(s.getClass().getSuperclass());
		/*
		 * �������static final variable�����ᵼ����ĳ�ʼ��(ǰ��:�������ܹ�ȷ����ֵ),
		 * ��Ϊfinal����ʵ�����Ǵ洢��ClassloadDemo_1��ĳ������е�(����ClassloadDemo_1.class�ļ���),
		 * ����֮��super_class��ClassloadDemo_1��֮��û���κι�ϵ��
		 */
		System.out.println(sub_class.final_string2);
	}

}
