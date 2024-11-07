package com.org.test;

public class functions {
	public String greeting()
	{
		return "Welcome";
	}
	public void sample()
	{
		System.out.println("Code executed successfully");
	}
public static void main(String args[])
{
	functions f=new functions();
	String result=f.greeting();
	System.out.println(result);
	f.sample();
}
}
