package com.bjsxt.proxy;

public class Client {

	public static void main(String[] args) {
		
		Tank t = new Tank();
		
		//1.调用move方法是 先做时间日志 在做log日志
		Moveable log = new TankLogProxy(t);
		Moveable m = new TankTimeProxy(log);
		m.move();
		
		//2.调用move方法时 先做log日志 在做时间日志
		Moveable time = new TankTimeProxy(t);
		Moveable log2 = new TankLogProxy(time);
		log2.move();
	}
}
