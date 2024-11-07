package com.org.test;

public class Logical {
   public static void main(String args[])
  {
	int a=10;
	int b=20;
	if(a==10 && b==10)
	{
		System.out.println("Both values are same");
	}
	else
	{
		System.out.println("Both values are not same");
	}
	if(a>10 || b>10)
	{
		System.out.println("true");
	}
	else {
		System.out.println("False");
	}
  }
}
