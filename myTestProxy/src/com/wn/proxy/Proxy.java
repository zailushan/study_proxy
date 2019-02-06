package com.wn.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import com.wn.proxy.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {

	public static Object newProxyInstance(Class infce, InvocationHandler hander) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String methodStr = "";
		String rt = "\r\n";
		
		Method[] methods = infce.getMethods();
		
		for(Method m : methods) {
			methodStr += "@Override" + rt + 
						 "public void " + m.getName() + "() {" + rt +
						 "    try {" + rt +
						 "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						 "    h.invoke(this, md);" + rt +
						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
						
						 "}";
		}
		
		String src = 
				"package com.wn.proxy;" +  rt +
				"import java.lang.reflect.Method;" + rt +
				"public class $Proxy1 implements " + infce.getName() + "{" + rt +
				"    public $Proxy1(InvocationHandler h) {" + rt +
				"        this.h = h;" + rt +
				"    }" + rt +
				
				
				"    com.wn.proxy.InvocationHandler h;" + rt +
								
				methodStr +
				"}";
		
		//生成代理的java文件
		String fileName = "d:/src/com/wn/proxy/$Proxy1.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler);
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		
		//load into memory and create an instance
		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.wn.proxy.$Proxy1");
		System.out.println(c);
		
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		Object m = ctr.newInstance(hander);
		//m.move();

		return m;
		
	}
}
