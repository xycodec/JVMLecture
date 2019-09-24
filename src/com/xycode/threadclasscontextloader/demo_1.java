package com.xycode.threadclasscontextloader;

import com.xycode.classloader.MyExtClassLoader;

/**
 * �߳����������������һ��ʹ��ģʽ
 * @author xycode
 *
 */
public class demo_1 implements Runnable{
	@Override
	public void run() {
		ClassLoader classLoader_bk=Thread.currentThread().getContextClassLoader();//����
		try {
			//����
			Thread.currentThread().setContextClassLoader(new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/"));
			//ʹ��
			System.out.println(Thread.currentThread().getContextClassLoader());
		}finally {
			//�ָ�
			Thread.currentThread().setContextClassLoader(classLoader_bk);
		}
	}
	
	public static void main(String[] args) {
		new Thread(new demo_1()).start();;
		
	}

}
