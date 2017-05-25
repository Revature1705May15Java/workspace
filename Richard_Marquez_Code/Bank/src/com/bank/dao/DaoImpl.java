package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements Dao {

	public boolean addUser(String fName, String lName, String password, String email) {
		boolean result = false;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO banker(fname, lname, password, email) VALUES(?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setString(3, password);
			ps.setString(4, email);

			if (ps.executeUpdate() == 1) {
				Logger.log("1 user added");
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateBalance(Account acct, double newBal) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public User getUser(String email) {
		User result = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM banker WHERE email=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				result = new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				Logger.log("retrieved user w/ email " + email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.log("failed to retrieve user w/ email " + email);
		}
		
		return result;
	}
	
	@Override
	public User getUser(int id) {
		User result = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM banker WHERE userid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				result = new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				Logger.log("retrieved user w/ id " + id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.log("failed to retrieve user w/ id " + id);
		}
		
		return result;
	}

	@Override
	public ArrayList<Account> getAccountsForUser(User u) {
		ArrayList<Account> accounts = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select account.accountid, account.balance, account.opened, account.closed, accounttype.typeid, accounttype.name " +
					"from bankeraccount " +
					"inner join banker on bankeraccount.userid = banker.userid " +
					"inner join account on bankeraccount.accountid = account.accountid " +
					"inner join accounttype on accounttype.typeid = account.typeid " +
					"where banker.userId=?";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Account a = new Account(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getDate(3).toLocalDate(),
						rs.getDate(4) != null ? rs.getDate(4).toLocalDate() : null,
						new AccountType(rs.getInt(5), rs.getString(6))
						);
				accounts.add(a);
				Logger.log("retrieved account w/ id " + a.getId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.log("failed to retrieve accts associate w/ " + u.getEmail());
		}
		
		return accounts;
	}
}
