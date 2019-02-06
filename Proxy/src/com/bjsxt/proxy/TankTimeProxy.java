package com.bjsxt.proxy;

public class TankTimeProxy implements Moveable{

	Moveable t;

	public TankTimeProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		//long start = System.currentTimeMillis();
		System.out.println("计时开始 。。。");
		t.move();
		long end = System.currentTimeMillis();
		//System.out.println("time: " + (end - start));
		System.out.println("计时结束 。。。");
	}
}
