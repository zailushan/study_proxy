package com.wn.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		//1.用动态代理实现在调用UserMag的 add delete 方法前后 添加自己的逻辑
		
		//被代理对象
		UserMag u = new UserMagImp(); 
		//对被代理对象的方法 前后加自己逻辑 的处理类
		InvocationHandler hander = new TimeHander(u);
		//产生代理对象
		UserMag proxy = (UserMag) Proxy.newProxyInstance(UserMag.class, hander);
		//代理对象调用方法
		//proxy.add();
		proxy.delete();
	}
}
