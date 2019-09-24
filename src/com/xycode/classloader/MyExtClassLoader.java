package com.xycode.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 加载指定目录下的class文件,并构造对象
 * @author xycode
 *
 */
public class MyExtClassLoader extends ClassLoader{
	// 指定文件目录
	private String location;
	private String suffix;
	public MyExtClassLoader(String location) {
		this.location=location;
		this.suffix=".class";
		
	}
	
	//name是类似com.xycode.xxx这样的字符串,要符合规范
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("findClass invoked!");
		byte[] datas = loadClassData(name);  
		return defineClass(null, datas, 0, datas.length);
		//也可以不用指定类名(类名其实是包含包名的, eg: com.xycode.xxx)
		//defineClass(): 将一个字节数组转换为一个类实例
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	protected byte[] loadClassData(String name) {  
	    FileInputStream fis = null;
	    ByteArrayOutputStream baos=null;
	    byte[] datas = null;  
		try {  
			fis = new FileInputStream(location+name.replace(".", "/")+suffix); 
			baos = new ByteArrayOutputStream();  
			int buf;  
			while((buf=fis.read())!=-1) {  
				baos.write(buf);  
			}  
			datas = baos.toByteArray();  

		 }catch(Exception e) {  
		     e.printStackTrace();  
		 }finally {
			try {
				if(baos!=null) baos.close();
				if(fis!=null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
				
		 }
		 return datas;  
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		MyExtClassLoader myExtClassLoader=new MyExtClassLoader("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		//loadClass()会调用findClass()方法,但这里却不会调用自定义的findClass
		Class<?> c1=myExtClassLoader.loadClass("com.xycode.classloader.my_object");//static code没有执行,说明只是加载了字节码,而没有初始化对象
		System.out.println(c1);
		System.out.println(c1.getClassLoader());//AppClassLoader,可以看出实际上进行加载工作的是AppClassLoader
		System.out.println(c1.hashCode());
		
		//但是如果修改class文件的路径,使其不在当前工程的classpath,此时AppClassLoader不能加载了,由于双亲委派模型,就会让myExtClassLoader去加载
		myExtClassLoader.setLocation("C:/Users/xycode/git/MultiThread_demo/MultiThread_demo/bin/");
		Class<?> c2=myExtClassLoader.loadClass("com.xycode.pro.CacheTest");
		System.out.println(c2.getClassLoader());//MyExtClassLoader
		System.out.println(c2.getClassLoader().getClass().getClassLoader());//AppClassLoader
		System.out.println(c2.hashCode());
		/**
		 * 注意,对于一个类加载器来说,如果已经加载过一个class文件,后续再次调用就不会再次加载了,会直接将之前加载的结果返回
		 * (这里说的加载不是指当前加载器真正地加载,如果实际的加载已经由父类加载器加载了,
		 * 	此时由于双亲委派模型,也不会重复加载,就会直接返回已加载的结果)
		 */
		
		
		myExtClassLoader.setLocation("C:/Users/xycode/Documents/$WorkSpace$/JVM_demo/bin/");
		Class<?> c3=myExtClassLoader.loadClass("com.xycode.classloader.my_object");//static code没有执行,说明只是加载了字节码,而没有初始化对象
		System.out.println(c3.getClassLoader());//MyExtClassLoader
		System.out.println(c3.getClassLoader().getClass().getClassLoader());//AppClassLoader
		System.out.println(c3.hashCode());
	}
}
