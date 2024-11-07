package com.org.test;

public class pattern3 {
public static void main(String args[])
{
	int n=5;
	for(int i=1;i<=n;i++)
	{
		int t=n;
		for(int j=i;j>0;j--)
		{
			System.out.print(t+" ");
			t--;
		}
		System.out.println();
	}
}
}
