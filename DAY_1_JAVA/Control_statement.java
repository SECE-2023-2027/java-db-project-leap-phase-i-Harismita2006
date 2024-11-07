package com.org.test;
import java.util.*;

public class Control_statement {
public static void main(String args[])
{
	int age;
	System.out.println("Enter your age:");
	Scanner sc=new Scanner(System.in);
	age=sc.nextInt();
	if(age>18)
	{
		System.out.println("Eligible to vote");
		if(age>50)
		{
			System.out.println("Eligible for pension");
		}
		else {
			System.out.println("Not Eligible for pension");
		}
	}
	else {
		System.out.println("Not eligible to vote");
	}
}
}
