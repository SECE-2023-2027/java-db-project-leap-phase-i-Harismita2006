package com.org.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.org.bank.model.Account;
import com.org.bank.util.Database_Connection;

public class AccountDAOimpl implements AccountDAO{

	@Override
	public void createAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO account (account_holder,account_type,balance,address,contact_no) VALUES(?,?,?,?,?)";
		try(Connection conn=Database_Connection.getConnection();
				PreparedStatement stat=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
			stat.setString(1,account.getAccount_holder());
			stat.setString(2,account.getAccount_type());
			stat.setDouble(3, account.getBalance());
			stat.setString(4,account.getAddress());
			stat.setString(5, account.getContact_No());
			int affectedRows = stat.executeUpdate();
			if(affectedRows>0) {
				ResultSet generatedKeys=stat.getGeneratedKeys();
            if(generatedKeys.next()) {
            	int account_id=generatedKeys.getInt(1);
            	if(account.getAccount_type().equals("Savings")) {
					String sqlsavingAccount="INSERT INTO SavingsAccount (acc_id,interest_rate) VALUES(?,?)";
					PreparedStatement stmtSaving=conn.prepareStatement(sqlsavingAccount);
					stmtSaving.setInt(1, account_id);
					stmtSaving.setDouble(2, 0.4);
					stmtSaving.executeUpdate();
				}
            	else if(account.getAccount_type().equals("Current"))
            	{
            		String sqlCurrentAccount="INSERT INTO CurrrentAccount (account_id,overdraft_limit)VALUES(?.?)";
            		PreparedStatement stmtSaving=conn.prepareStatement(sqlCurrentAccount);
					stmtSaving.setInt(1, account_id);
					stmtSaving.setDouble(2, 5000.00);
					stmtSaving.executeUpdate();
            	}
				}
			}
		}
		System.out.println("Account created successfully");
	}

	@Override
	public Account viewAccount(int accountId) throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Account where account_id=?";
		Account account = null;
		try(Connection conn=Database_Connection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql))
		{
		stmt.setInt(1, accountId);
		ResultSet rs=stmt.executeQuery();
		  if (rs.next()) {
	            account = new Account(rs.getInt("account_id"), rs.getString("account_holder"),
	            rs.getString("account_type"),
	            rs.getDouble("balance"),
	            rs.getString("address"),
	            rs.getString("contact_no"));      
		}
		}
		return account;
	}

	@Override
	public void updateAccountInfo(int accountId, String newAddress, String newContact) throws Exception {
			// TODO Auto-generated method stub
			String sql="UPDATE account SET address = ?, contact_no = ? WHERE account_id = ?";
			try (Connection conn=Database_Connection.getConnection();
					PreparedStatement stmt=conn.prepareStatement(sql)){
				stmt.setString(1, newAddress);
				stmt.setString(2, newContact);
				stmt.setInt(3, accountId);
				int rowsAffected = stmt.executeUpdate();
				if(rowsAffected>0) {
					System.out.println("Updated");
				}
				else {
					System.out.println("Acccount not found");
				}
			}
		}

	@Override
	public void getBalance(int accountId) {
		// TODO Auto-generated method stub
		
	}

}
