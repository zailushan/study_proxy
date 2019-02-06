package com.wn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHander implements InvocationHandler{

	UserMag target;
	
	public TimeHander(UserMag target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("时间处理逻辑start。。。");
		method.invoke(target, args);
		System.out.println("时间处理逻辑end ...");
		return null;
	}

}
