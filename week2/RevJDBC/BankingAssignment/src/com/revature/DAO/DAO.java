package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.POJO.User;
import com.revature.UTIL.ConnectionUtil;

public class DAO implements DAOInterface {

	@Override
	public User createUser(String u_name, String pw, String fn, String ln, String email) {

		try (Connection connect = ConnectionUtil.getConnection()) {

			// Step 1 in update methods, set autocommit to false
			connect.setAutoCommit(false);

			// step 2. account for automatic Primary key insert
			String[] pk = new String[1];
			pk[0] = "u_id";// string = name of pk column
			// does this need to be an array, can it be a string?

			String sql = "insert into users (username, password, firstname, lastname, email)"
					+ "values(?, ?, ?, ?, ?)";

			PreparedStatement ps = connect.prepareStatement(sql,pk);
			ps.setString(1, u_name);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setString(5, email);
			
			int numRowsAffected = ps.executeUpdate();
			
			System.out.println("youve inserted " + numRowsAffected + " users");
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
			int id =0;
			while(generatedKeys.next()){
				id = generatedKeys.getInt(1);
				System.out.println(id); //column number
			}
			
			//With auto commit set to false
			connect.commit();
			
			User ret = new User(id, u_name, pw, fn, ln, email);
			
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
