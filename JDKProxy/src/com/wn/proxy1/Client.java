package com.wn.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		
		//通过代理对象， 调用被代理对象的add() 方法前后加上日志记录
		UserManager u = new UserManagerImp();
		
		InvocationHandler handler = new LogInvocationHandler(u);
		
		UserManager proxy = (UserManager)Proxy.newProxyInstance(u.getClass().getClassLoader(), u.getClass().getInterfaces(), handler);
		
		proxy.add();
		
		
		
	}
}
