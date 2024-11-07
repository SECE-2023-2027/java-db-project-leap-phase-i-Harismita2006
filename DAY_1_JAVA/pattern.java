package com.org.test;

public class pattern {
public static void main(String args[])
{
	int r;
	r=5;
	for(int i=1;i<=r;i++)
	{
		for(int k=i;k<=r;k++)
		{
			System.out.print(" ");
		}
		for(int j=1;j<=i;j++)
		{
			System.out.print("*"+" ");
		}
		System.out.println();
	}
}
}
  