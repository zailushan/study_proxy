package com.wn.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler{

	private Object target;
	
	public LogInvocationHandler(Object o) {
		this.target = o;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("日志记录开始。。。");
		
		method.invoke(target, null);
		
		System.out.println("日志记录结束。。。");
		
		return null;
	}

}
