package com.javalec.ex;

public class Calculator2 {
    private int firstNum;
    private int secondNum;
    private ArrayClass arr;
    
    //�����ڷ� DI (������ ����)�ϱ�
    public Calculator2(final int first, final int second, ArrayClass arr) 
    {
    	this.firstNum = first;
    	this.secondNum = second;
    	this.arr = arr;
    }
    
    public void setFirstNum(final int num)
    {
        this.firstNum = num;
    }

    public void setSecondNum(final int num)
    {
        this.secondNum = num;
    }

    public void setArr(ArrayClass arr) 
    {
    	this.arr = arr;    	
    }
    
    public ArrayClass getArr() 
    {
    	return arr;
    }
    
    public void Add()
    {
    	System.out.println(Integer.toString(this.firstNum + this.secondNum));
    	arr.getArr().add(this.firstNum + this.secondNum);
    }

    public void Sub()
    {
    	System.out.println(Integer.toString(this.firstNum - this.secondNum));
    	arr.getArr().add(this.firstNum - this.secondNum);
    }

    public void Mul()
    {
    	System.out.println(Integer.toString(this.firstNum * this.secondNum));  
    	arr.getArr().add(this.firstNum * this.secondNum);
    }

    public void Div()
    {
    	System.out.println(Integer.toString(this.firstNum / this.secondNum));  
    	arr.getArr().add(this.firstNum / this.secondNum);
    }
}
