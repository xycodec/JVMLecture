package com.xycode.classloader;

public class classloader_demo_2 {
	/*
	 * ����������������������������ģ����Ǹ���Java Runtime���Զ������ġ�
	 * ����������������Ԫ�����͵����������ͬ��
	 * ���Ԫ��������primitive type(int,float,double,short,long,boolean)����������û�����������
	 */
	public static void main(String[] args) {
		String[] s=new String[10];
		System.out.println(s.getClass().getClassLoader());//null,����ļ�������Ԫ�����͵��������һ��
		
		my_object[] o=new my_object[10];
		System.out.println(o.getClass().getClassLoader());//AppClassLoader
		
		int[] i=new int[10];
		System.out.println(i.getClass().getClassLoader());//null
		//���null�����Ǳ�ʾbootstrap ClassLoader,���Ǳ�ʾû���������,��Ϊint��primitive type
	}

}
