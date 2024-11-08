package com.org.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Operations {
public static void readUsers()
{
	String sql="SELECT * from student";
    try (Connection connection = Database_Manager.getConnection();
		PreparedStatement statement=connection.prepareStatement(sql);
		ResultSet resultSet=statement.executeQuery()){
    	while(resultSet.next())
    	{
    		int id=resultSet.getInt("student_id");
    		String name=resultSet.getString("name");
    		String address=resultSet.getString("address");
    		String department=resultSet.getString("department");
    		int dept_id=resultSet.getInt("dept_id");
    		System.out.println("ID: " + id + ", Name: " + name + ",Address: " + address + ",Department:" + department + " ,Dept id: " + dept_id);
    	}
	}
    catch (SQLException e) {
		e.printStackTrace();
	}
}
    public static void UpdateUsers(int studentId, String newName, String newAddress, String newDepartment, int newDeptId) {
        String sql = "UPDATE student SET name = ?, address = ?, department = ?, dept_id = ? WHERE student_id = ?";

        try (Connection connection = Database_Manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setString(2, newAddress);
            statement.setString(3, newDepartment);
            statement.setInt(4, newDeptId);
            statement.setInt(5, studentId);
            statement.executeUpdate();
            User_Operations.readUsers();

        } catch (SQLException e) {
            e.printStackTrace();
        }
 }
    public static void DeleteUsers(int newid)
    {
    	String sql="delete from student where student_id=?";
    	 try (Connection connection = Database_Manager.getConnection();
    	         PreparedStatement statement = connection.prepareStatement(sql)) {
    	        statement.setInt(1, newid);
                statement.executeUpdate();
                User_Operations.readUsers();
                
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    }
public static void InsertUsers(int newid,String name,String address,String department,int dept_id)
{
	String sql="insert into student values(?,?,?,?,?)";
	 try (Connection connection = Database_Manager.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
		 statement.setInt(1,newid);
		 statement.setString(2, name);
		 statement.setString(3,address);
		 statement.setString(4, department);
		 statement.setInt(5,dept_id);
		 statement.executeUpdate();
		 User_Operations.readUsers();
	 }
	 catch (SQLException e) {
	        e.printStackTrace();
	    }
}
public static void main(String[] args) {
	User_Operations.readUsers();
	User_Operations.UpdateUsers(10,"Karthick Reddy", "Dindigul", "AIDS", 105);
	User_Operations.DeleteUsers(9);
	User_Operations.InsertUsers(9,"Akanya Rao","Ooty", "EEE", 104);
}
}
