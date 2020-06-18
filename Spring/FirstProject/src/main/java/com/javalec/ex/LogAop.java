package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAop {
	@Pointcut("within(com.javalec.ex.*)")
	private void pointcutMethod() {}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is Start.");
		long st = System.currentTimeMillis();
		
		try 
		{
			Object obj = joinpoint.proceed();
			return obj;
		}
		finally 
		{
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is Finished.");
			System.out.println(signatureStr + " 경과 시간 : " + (et-st));
		}
	}
	
	@Before("within(com.javalec.ex.*)")
	public void beforeAdvice() 
	{
		System.out.println("beforeAdvice()");
	}
}
