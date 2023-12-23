package com.wfu.test;

import entity.User;

public class Test {
	public static void main(String[]args) {
		UserDaoImpl dao=new UserDaoImpl();
		User user=new User();
		user.setName("jack");
		user.setPassword("123");
		int x=dao.addUser(user);
		if(x>0) {
			System.out.println("插入成功");
		}
	}

}
