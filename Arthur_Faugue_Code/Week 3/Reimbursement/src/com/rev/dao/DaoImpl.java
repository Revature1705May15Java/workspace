package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.util.ConnectionFactory;
import com.rev.pojo.Request;
import com.rev.pojo.User;

public class DaoImpl implements DAO{

	@Override
	public User userLogin(String em, String pw) {
		User u = new User();
		ArrayList<Request> reqs = new ArrayList<Request>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM USER_E WHERE EMAIL = ? AND PASSWRD = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, pw);
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setEm(userinfo.getString(2));
				u.setPw(userinfo.getString(3));
				u.setFn(userinfo.getString(4));
				u.setLn(userinfo.getString(5));
				u.setIsBoss(userinfo.getInt(6));
			}
			reqs = getUserRequest(u);
			u.setUserRequest(reqs);
			
//			System.out.println(u.toString());
			return u;
			
		}catch(SQLException e){
			System.out.println("userLogin Error");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public ArrayList<Request> getUserRequest(User u) {
		ArrayList<Request> reqArr = new ArrayList<Request>();
		Request req = new Request();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT *  FROM REQUEST R "
					+ "INNER JOIN USER_E E "
					+ "ON R.REQUESTER_ID = E.U_ID "
					+ "where E.U_ID = ?";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, u.getId());
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				req.setId(userinfo.getInt(1));
				req.setStateId(userinfo.getInt(2));
				req.setReqDate(userinfo.getDate(3));
				req.setResDate(userinfo.getDate(4));
				req.setAmount(userinfo.getInt(5));
				req.setReqId(userinfo.getInt(6));
				req.setResId(userinfo.getInt(7));
				req.setPurpose(userinfo.getString(8));
				req.setNote(userinfo.getString(9));
				
//				System.out.println(req.toString());
				reqArr.add(req);
				req = new Request();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reqArr;
	}

	@Override
	public String getRequestType(Request r) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
