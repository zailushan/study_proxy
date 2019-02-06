package com.bjsxt.proxy;

public class TankLogProxy implements Moveable{

	Moveable t;

	public TankLogProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		System.out.println("日志开始 。。。");
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("日志结束 。。。");
	}
}
