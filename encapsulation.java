package com.org.test;
public class encapsulation {
	public static void main(String args[])
{
		encapsulation3 e3=new encapsulation3();
		e3.set_empid(101);
		e3.set_name("Ram");
		e3.set_salary(30000);
		int id=e3.get_empid();
		String name=e3.get_name();
		int salary=e3.get_salary();
		System.out.println("Employee id: "+ id);
		System.out.println("Employee name: "+ name);
		System.out.println("Employee salary: "+ salary);
}
}

