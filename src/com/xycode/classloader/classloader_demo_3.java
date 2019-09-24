package com.xycode.classloader;

public class classloader_demo_3 {
	public static void main(String[] args) throws ClassNotFoundException {
		MyExtClassLoader myExtClassLoader=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		//loadClass()�����findClass()����,������ȴ��������Զ����findClass
		Class<?> c1=myExtClassLoader.loadClass("com.xycode.classloader.my_object");//static codeû��ִ��,˵��ֻ�Ǽ������ֽ���,��û�г�ʼ������
		System.out.println(c1.getClassLoader());//AppClassLoader
		//���Կ���ʵ���Ͻ��м��ع�������AppClassLoader
		System.out.println(c1.hashCode());
		
		
		Class<?> c2=myExtClassLoader.loadClass("com.xycode.classloader.my_object");//static codeû��ִ��,˵��ֻ�Ǽ������ֽ���,��û�г�ʼ������
		System.out.println(c2.getClassLoader());//MyExtClassLoader
		System.out.println(c2.getClassLoader());//AppClassLoader
		System.out.println(c2.hashCode());
		/**
		 * ע��,����һ�����������˵,����Ѿ����ع�һ��class�ļ�,�����ٴε��þͲ����ٴμ�����,��ֱ�ӽ�֮ǰ���صĽ������
		 * (����˵�ļ��ز���ָ��ǰ�����������ؼ���,���ʵ�ʵļ����Ѿ��ɸ��������������,
		 *   ��ʱ����˫��ί��ģ��,Ҳ�����ظ�����,�ͻ�ֱ�ӷ����Ѽ��صĽ��)
		 *   �����ԴӴ�ӡclass��hashcode���Կ���,c1,c2��hashcode��һ�µ�
		 */
	}
}
