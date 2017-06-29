package com.bank.pojos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.util.ConnectionUtil;

public class User {
	Logger Log = new Logger();
	int id;
	
	int numAccounts;
	
	String fn,ln,pw,uname;
	ArrayList <Account> userAccounts;
	public User() {
		super();
	}
	public User(int id, String fn, String ln, String uname, String pw, ArrayList<Account> userAccounts) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.uname = uname;
		this.userAccounts = userAccounts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getNumAccounts() {
		return numAccounts;
	}
	public void setNumAccounts(int numAccounts) {
		this.numAccounts = numAccounts;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public ArrayList<Account> getUserAccounts() {
		return userAccounts;
	}
	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", uname=" + uname + ", userAccounts="
				+ userAccounts + "]";
	}
	
	public User getUser(String uname){
		User u = new User();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from users where username=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname);
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setUname(userinfo.getString(4));
				u.setPw(userinfo.getString(5));				
			}
			//ADD LOGGG!!!
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

		
		
	}

