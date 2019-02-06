package com.wn.proxy1;

public class UserManagerImp implements UserManager{

	@Override
	public void add() {
		System.out.println("添加用户...");
	}

	@Override
	public void delete() {
		System.out.println("删除用户...");
	}

}
