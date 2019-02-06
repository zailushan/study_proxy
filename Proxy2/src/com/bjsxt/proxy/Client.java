package com.bjsxt.proxy;

public class Client {

	public static void main(String[] args) {
		
		Tank t = new Tank();
		
		Moveable m = (Moveable)Proxy.newProxyInstance();
		m.move();
	}
}
