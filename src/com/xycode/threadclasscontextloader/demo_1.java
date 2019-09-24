package com.xycode.threadclasscontextloader;

import com.xycode.classloader.MyExtClassLoader;

/**
 * 线程上下文类加载器的一般使用模式
 * @author xycode
 *
 */
public class demo_1 implements Runnable{
	@Override
	public void run() {
		ClassLoader classLoader_bk=Thread.currentThread().getContextClassLoader();//备份
		try {
			//设置
			Thread.currentThread().setContextClassLoader(new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/"));
			//使用
			System.out.println(Thread.currentThread().getContextClassLoader());
		}finally {
			//恢复
			Thread.currentThread().setContextClassLoader(classLoader_bk);
		}
	}
	
	public static void main(String[] args) {
		new Thread(new demo_1()).start();;
		
	}

}
