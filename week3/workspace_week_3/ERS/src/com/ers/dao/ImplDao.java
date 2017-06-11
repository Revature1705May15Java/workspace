package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.pojo.Request;
import com.ers.pojo.User;
import com.ers.util.ConnectionFactory;

public class ImplDao implements Dao{

	static ArrayList<Request> requests = new ArrayList<Request>();
	
	@Override
	public User getUser(String username) {
		User u = new User();

		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM employee WHERE username = ?";
					
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				u.setUsername(info.getString(1));
				u.setPassword(info.getString(2));
				u.setId(info.getInt(3));
				u.setFn(info.getString(4));
				u.setLn(info.getString(5));
				u.setRank(info.getInt(6));
				u.setRequests(getUserRequests(u.getId()));
			}
			
			if(u.getUsername() != null){System.out.println("Found a user");} //log.log("Retrieved user by username: " + userName);
			else {
				//log.log("Failed to retrieve user by username: " + userName);
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User getUser(int id) {
		User u = new User();

		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM employee WHERE empid = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			while(info.next()){ 
				u.setUsername(info.getString(1));
				u.setPassword(info.getString(2));
				u.setId(info.getInt(3));
				u.setFn(info.getString(4));
				u.setLn(info.getString(5));
				u.setRank(info.getInt(6));
				u.setRequests(getUserRequests(u.getId()));
			}
			
			if(u.getUsername() != null){System.out.println("Found a user");} //log.log("Retrieved user by username: " + userName);
			else {
				//log.log("Failed to retrieve user by username: " + userName);
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	@Override
	public int addUser(String uname, String pw, String fn, String ln, int emp_rank) {
		int numRowsAffected = 0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "INSERT INTO employee(username,password,firstname,lastname,emp_rank)"
						+ "VALUES (?,?,?,?,?)";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setInt(5, emp_rank);
			
			numRowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numRowsAffected;
	}
	
	public ArrayList<Request> getUserRequests(int id){ 
		requests = new ArrayList<Request>();
		Request temp = new Request();
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM requests WHERE empid = ?";
			String sql2 = "SELECT name FROM statetype WHERE stateid = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ResultSet info = ps.executeQuery();
			int i = 0, num = 0;
			while(info.next()){
				
				temp = new Request();
				temp.setId(info.getInt(1));
				temp.setDateOpened(info.getDate(2));
				temp.setDateClosed(info.getDate(3));
				temp.setBalance(info.getDouble(4));
				temp.setPurpose(info.getString(5));
				temp.setRequesterId(info.getInt(6));
				temp.setAdminId(info.getInt(7));
				
				num = info.getInt(8);
				ps2.setInt(1, num); // setting request state so it can be queried each iteration to
									// collect the correct state type in the look-up table.
				ResultSet info2 = ps2.executeQuery();
				info2.next();
				temp.setType(info2.getString(1));
				
				requests.add(i, temp);
				i++;			
			}
			return requests;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int addRequest(int amt, String purpose, int id) {
		int numRowsAffected = 0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			System.out.println("VALUES: " + amt + " : "+ purpose + " : "+ id);
			String sql = "INSERT INTO requests(amount,purpose,empid)"
						+ "VALUES (?,?,?)";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, amt);
			ps.setString(2, purpose);
			ps.setInt(3, id);
			
			numRowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numRowsAffected;
	}

	@Override
	public ArrayList<Request> getRequestsByEmployeeId(int id) {
		ArrayList<Request> list = new ArrayList<Request>();
		Request request = new Request();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM requests WHERE empid = ?";
			String sql2 ="SELECT name FROM statetype WHERE stateid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			int i = 0;
			while(info.next()){
				
				request = new Request();
				request.setId(info.getInt(1));
				request.setDateOpened(info.getDate(2));
				request.setDateClosed(info.getDate(3));
				request.setBalance(info.getInt(4));
				request.setPurpose(info.getString(5));
				request.setRequesterId(6);
				request.setAdminId(info.getInt(7));
				
				int num = info.getInt(8);
				ps2.setInt(1, num); // setting request type so it can be queried each iteration to
									// collect the correct request type in the look-up table.
				ResultSet info2 = ps2.executeQuery();
				info2.next();
				request.setType(info2.getString(1));
				
				request.setAdminNote(info.getString(9));
				list.add(i, request);
				i++;			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
