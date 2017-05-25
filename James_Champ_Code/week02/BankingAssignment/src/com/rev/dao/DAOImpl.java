package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.rev.log.Logger;
import com.rev.pojos.Account;
import com.rev.util.ConnectionUtil;

public class DAOImpl implements DAO{
	private static Logger log = new Logger();
	
	@Override
	public int updateBalance(Account account, double newBalance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(String firstName, String lastName, String password, String email) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{CALL create_new_user(?, ?, ?, ?)}";
		
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, firstName);
			cs.setString(2, lastName);
			cs.setString(3, password);
			cs.setString(4, email);
			
			int num = cs.executeUpdate();
			
			log.log(num + " users added.");
			
			return num;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
