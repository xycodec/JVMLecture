package com.xycode.GC;

/**
 * jvm args:
 * 		-verbose:gc
 * @author xycode
 *
 */

public class GC_demo_4 {

	public static void main(String[] args) {
		{//��palceholder��������������{ }��
			byte[] palceholder=new byte[64*1024*1024];
		}
		int a=0;//�������þֲ�������
		System.gc();
	}

}
