package com.org.test;

public class pattern4 {
public static void main(String args[])
{
	int n=5;
	for(int i=1;i<=n;i++)
	{
		for(int k=i-1;k>=0;k--)
		{
			System.out.print(" ");
		}
		for(int j=n;j>=i;j--)
		{
			System.out.print(j+" ");
		}
		System.out.println();
	}	
}
}
