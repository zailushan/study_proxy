package com.bjsxt.compiler.test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.bjsxt.proxy.Moveable;
import com.bjsxt.proxy.Tank;

public class Test1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String rt = "\r\n";
		String src = 
				"package com.bjsxt.proxy;" + rt + 
				"public class TankTimeProxy implements Moveable{" + rt +

				"	Moveable t;" + 

				"	public TankTimeProxy(Moveable t) {" + rt + 
				"		super();" + rt + 
				"		this.t = t;" + rt +
				"	}" + rt + 

				"	@Override" + rt + 
				"	public void move() {" + rt + 
				"		System.out.println(\"计时开始 。。。\");" + rt +
				"		t.move();" + rt +
				"		System.out.println(\"计时结束 。。。\");" + rt + 
				"	}" + rt + 
					
				"}";
		
		String fileName = System.getProperty("user.dir") + "/src/com/bjsxt/proxy/TankTimeProxy.java";
		//System.out.println(fileName);
		FileWriter fw = new FileWriter(fileName);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compil 编译
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load到内存 创建对象
		URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.bjsxt.proxy.TankTimeProxy");
		//System.out.println(c);
		
		Constructor<Moveable> ctr = c.getConstructor(Moveable.class);
		Tank tank = new Tank(); 
		Moveable m = ctr.newInstance(tank);
		m.move();
		
	}
}
