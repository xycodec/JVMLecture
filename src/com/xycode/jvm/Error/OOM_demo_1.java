package com.xycode.jvm.Error;
import java.util.ArrayList;
import java.util.List;

/*
 * OutOfMemoryError
 * JVM args:
 * 		-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class OOM_demo_1 {
	static class OOMObject{
		
	}
	public static void main(String[] args) {
		List<Object> list=new ArrayList<>();
		while(true) {
			list.add(new OOMObject());
		}
	}

}
