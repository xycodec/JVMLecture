package com.xycode.jvm.Error;
/*
 * ���߳������ջ��ȳ���JVM�����������,���׳�StackOverflowError
 * JVM args:
 * 		-Xss512k (����JVM��ջ��СΪ512k)
 */
public class StackOverflowError_demo_1 {
	int stack_depth=1;
	public void stackLeak() {
		++stack_depth;
		stackLeak();//�ݹ������ջ���
	}
	
	public static void main(String[] args) {
		StackOverflowError_demo_1 s=new StackOverflowError_demo_1();
		try {
			s.stackLeak();
		}catch(Throwable e) {
			System.out.println("Max Stack Depth: "+s.stack_depth);//���ֵ8000��ͷ������
			//eg:Max Stack Depth: 8337
			throw e;
		}
	}

}
