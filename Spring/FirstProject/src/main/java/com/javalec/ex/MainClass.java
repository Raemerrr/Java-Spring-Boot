package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String _path = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(_path);
		AdminConnection connection = ctx.getBean("adminConnection",AdminConnection.class);
		System.out.println(connection.getAdminID());
		System.out.println(connection.getAdminPW());
		ctx.close();
	}
}
