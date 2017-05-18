package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.UTIL.ConnectionUtil;

public class DAO implements DAOInterface{

	@Override
	public String getStatus(int statuskey) throws SQLException {
		
		try (Connection connect = ConnectionUtil.getConnection();){
		
			String sql = "select status_name from status where status_id = ? ";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, statuskey);
		
			
			ResultSet rs = ps.executeQuery();
			
			String status = null;
			
			while(rs.next()){
				status = rs.getString("status_name");
			}
			
			rs.close();
			return status;		
		}
		
	}
	

}
