package com.xycode.jvm.Error;
/*
 * 当线程请求的栈深度超过JVM允许的最大深度,将抛出StackOverflowError
 * JVM args:
 * 		-Xss512k (限制JVM的栈大小为512k)
 */
public class StackOverflowError_demo_1 {
	int stack_depth=1;
	public void stackLeak() {
		++stack_depth;
		stackLeak();//递归地增加栈深度
	}
	
	public static void main(String[] args) {
		StackOverflowError_demo_1 s=new StackOverflowError_demo_1();
		try {
			s.stackLeak();
		}catch(Throwable e) {
			System.out.println("Max Stack Depth: "+s.stack_depth);//输出值8000出头的样子
			//eg:Max Stack Depth: 8337
			throw e;
		}
	}

}
