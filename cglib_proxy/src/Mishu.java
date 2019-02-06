import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Mishu这个类相当于jdk动态代理中实现InvocationHandler
 * 接口的实现类
 */
public class Mishu implements MethodInterceptor{

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object result = null;
		//对目标对象调用方法时，要扩展的逻辑
		System.out.println("预约时间");
		//arg3：被子类复写的方法，arg0：生成的目标类的子类，arg2：方法的参数
		result = arg3.invokeSuper(arg0, arg2); //调用arg0对象的父类的arg3方法。
		//对目标对象调用方法时，要扩展的逻辑
		System.out.println("备注");
		return result;
	}
}
