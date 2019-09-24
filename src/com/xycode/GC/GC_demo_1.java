package com.xycode.GC;
/*
 * JVM args:
 * 		-XX:+PrintGCDetails
 */
public class GC_demo_1 {
	static class RefGC{
		Object ref=null;
		static final int _1MB=1024*1024;
		byte[] bigSize=new byte[2*_1MB];
	}
	
	public static void main(String[] args) {
		RefGC r1=new RefGC();
		RefGC r2=new RefGC();
		r1.ref=r2;
		r2.ref=r1;
		
		r1=null;
		r2=null;
		
		System.gc();//打印的GC日志:  GC(0) Pause Full (System.gc()) 7M->0M(8M) 3.350ms
	}

}
