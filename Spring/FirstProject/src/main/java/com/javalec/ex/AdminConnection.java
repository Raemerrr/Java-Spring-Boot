package com.javalec.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AdminConnection implements InitializingBean, DisposableBean {
	private String adminID;
	private String adminPW;
	
	AdminConnection(String adminID, String adminPW)
	{
		this.adminID = adminID;
		this.adminPW = adminPW;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPW() {
		return adminPW;
	}

	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}
	
	public void getAdminInfo() 
	{
		System.out.println("adminID : "+ adminID + "\n" + "adminPW : " + adminPW);
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy()!!!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet()!!");
	}
	
	
}
