package com.wn.proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

	void invoke(Object o, Method m);
}
