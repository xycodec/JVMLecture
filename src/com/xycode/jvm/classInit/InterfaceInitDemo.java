package com.xycode.jvm.classInit;

/**
 * Interface�ĳ�ʼ����Class��ͬ,������Interface�ľ�̬�������ᵼ�¸�Interface�ĳ�ʼ��
 * ���ø�Interface�ľ�̬����Ҳ���ᵼ����Interface�ĳ�ʼ��
 * ԭ��:��ΪInterface�еı���Ĭ�϶���static final��,���۲μ�Class�Ľ���
 * @author xycode
 *
 */
public class InterfaceInitDemo {
	public static void main(String[] args) {
		System.out.println(superImpl.b);// �ڳ�ʼ��һ����ʱ���������ȳ�ʼ������ʵ�ֵĽӿڡ�
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



