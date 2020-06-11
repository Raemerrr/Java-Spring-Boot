package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calculator calculator = new Calculator();
		//calculator.setFirstNum(10);
		//calculator.setSecondNum(2);
		//System.out.println(calculator.Add());
		String _path = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(_path);
		Calculator c = ctx.getBean("calculator",Calculator.class);
		c.Add();
		c.Sub();
		c.Mul();
		c.Div();
		for(Integer d : c.getArr().getArr())
		{
			System.out.println(d.toString());
		}
		System.out.println("=========================경계선=========================");
		Calculator2 c2 = ctx.getBean("calculator2",Calculator2.class);
		c2.Add();
		c2.Sub();
		c2.Mul();
		c2.Div();
		for(Integer d : c2.getArr().getArr()) 
		{
			System.out.println(d.toString());
		}
		System.out.println("=========================경계선=========================");
		c.Add();
		c.Sub();
		c.Mul();
		c.Div();
		for(Integer d : c.getArr().getArr())
		{
			System.out.println(d.toString());
		}
		
		//사용이 끝나면 닫아주자!
		ctx.close();
	}
}
