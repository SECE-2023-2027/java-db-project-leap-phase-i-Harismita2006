package com.org.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list {

	public static void main(String[] args) {
		List <Integer> l=new ArrayList<>();
		l.add(10);
		l.add(100);
		l.add(1);
		l.add(20);
		l.add(22);
		l.add(11);
		l.add(19);
	   list.max(l);
	   list.min(l);
	   
	}

	static void max(List<Integer> l)
	{
		Iterator it=l.iterator();  
		int max=0;
		while(it.hasNext())
		{
			int curr=(int)it.next();
			if(curr>max)
			{
				max=(int)curr;
			}
		}
		System.out.println("Maximum elemnt is " + max);
	}
	static void min(List<Integer> l)
	{
		Iterator it=l.iterator();  
		int min=100000000;
		while(it.hasNext())
		{
			int curr=(int)it.next();
			if(curr<min)
			{
				min=(int)curr;
			}
		}
		System.out.println("Minimum element is " + min);
	}
}
