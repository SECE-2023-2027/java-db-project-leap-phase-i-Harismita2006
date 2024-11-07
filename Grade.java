package com.org.test;
import java.util.*;


public class Grade {
public static void main(String args[])
{
	int mark;
	Scanner cs=new Scanner(System.in);
	System.out.println("Enter your marks:");
	mark=cs.nextInt();
	if(mark<30)
	{
		System.out.println("Grade C");
	}
	else if(mark>=30 && mark<50)
	{
		System.out.println("Grade B");
	}
	else if(mark>=50 && mark<80)
	{
		System.out.println("Grade A");
	}
	else if(mark>=80 && mark<=100)
	{
		System.out.println("Grade O");
	}
	else {
		System.out.println("Mark cannot be greater than 100");
	}
}
}
