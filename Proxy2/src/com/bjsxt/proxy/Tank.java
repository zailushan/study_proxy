package com.bjsxt.proxy;

import java.util.Random;

public class Tank implements Moveable{

	@Override
	public void move() {
		System.out.println("Tank Moveing...");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
