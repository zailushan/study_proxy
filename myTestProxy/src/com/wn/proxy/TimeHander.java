package com.wn.proxy;

import java.lang.reflect.Method;

public class TimeHander implements InvocationHandler{

	private Object target;
	
	public TimeHander(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("时间处理start，，，，");
		
		try {
			m.invoke(target);
		} catch (Exception e) {
			
		}
		
		System.out.println("时间处理end 。。。。");
	}

}
