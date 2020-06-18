package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String _path = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(_path);
		Calculator cal = ctx.getBean("calculator",Calculator.class);
		cal.Add();
		ctx.close();
	}
}
 