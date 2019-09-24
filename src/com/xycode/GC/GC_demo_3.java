package com.xycode.GC;
/**
 * -Xms100M -Xmx100M -XX:+UseSerialGC
 */
import java.util.ArrayList;
import java.util.List;

public class GC_demo_3 {
	static class OOMObject{
		byte[] b=new byte[64*1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list=new ArrayList<>();
		for(int i=0;i<num;++i) {//fillSpeed: 64KB/50ms
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws InterruptedException {
		fillHeap(1000);
	}

}
