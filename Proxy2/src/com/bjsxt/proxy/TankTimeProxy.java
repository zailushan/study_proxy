package com.bjsxt.proxy;
public class TankTimeProxy implements Moveable{
	Moveable t;	public TankTimeProxy(Moveable t) {
		super();
		this.t = t;
	}
	@Override
	public void move() {
		System.out.println("计时开始 。。。");
		t.move();
		System.out.println("计时结束 。。。");
	}
}