package com.org.test;

public class encapsulation1 {
private int emp_id;
private String name;
private int salary;
public void set_empid(int id)
{
	this.emp_id=id;
}
public int get_empid()
{
	return this.emp_id;
}
public void set_name(String name)
{
	this.name=name;
}
public String get_name()
{
	return this.name;
}
public void set_salary(int amount)
{
	this.salary=amount;
}
public int get_salary()
{
	return this.salary;
}
}
