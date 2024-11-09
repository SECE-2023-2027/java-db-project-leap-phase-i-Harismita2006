package com.org.bank.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {
	private static final String URL="jdbc:mysql://localhost:3307/bank_app";
	private static final String USERNAME="root";
	private static final String PASSWORD="W7301@jqir#";
	public static Connection getConnection() throws SQLException {
	{
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
}


