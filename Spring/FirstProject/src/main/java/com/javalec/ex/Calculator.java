package com.javalec.ex;

public class Calculator {
    private int firstNum;
    private int secondNum;
    
    public void setFirstNum(final int num)
    {
        this.firstNum = num;
    }

    public void setSecondNum(final int num)
    {
        this.secondNum = num;
    }
    
    public void Add()
    {
    	System.out.println(Integer.toString(this.firstNum + this.secondNum));
    }

    public void Sub()
    {
    	System.out.println(Integer.toString(this.firstNum - this.secondNum));
    }

    public void Mul()
    {
    	System.out.println(Integer.toString(this.firstNum * this.secondNum));  
    }

    public void Div()
    {
    	System.out.println(Integer.toString(this.firstNum / this.secondNum)); 
    }
}
