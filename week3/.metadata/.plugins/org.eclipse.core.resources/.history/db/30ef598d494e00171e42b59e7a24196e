package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ers.util.ConnectionFactory;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public class DaoImpl implements DAO {

	public DaoImpl() {

	}

	@Override
	public Employee getEmployee(String email) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from employee where email=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet info = ps.executeQuery();
			Employee temp = new Employee();
			while(info.next()){
				temp.setEmail(info.getString(1));
				temp.setPassword(info.getString(2));
				temp.setId(info.getInt(3));
				temp.setFirstname(info.getString(4));
				temp.setLastname(info.getString(5));
				temp.setIsmanager(info.getInt(6));
				return temp;
			}


		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployee(int employeeid) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from employee where id=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, employeeid);
			ResultSet info = ps.executeQuery();

			Employee temp = new Employee();
			System.out.println("here");
			while(info.next()){
				System.out.println("got it");
				temp.setEmail(info.getString(1));
				temp.setPassword(info.getString(2));
				temp.setId(info.getInt(3));
				temp.setFirstname(info.getString(4));
				temp.setLastname(info.getString(5));
				temp.setIsmanager(info.getInt(6));
				return temp;
			}


		}catch(SQLException e){
			System.out.println("uhoh");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Request getRequest(int requestid) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from requests where requestid=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, requestid);
			ResultSet info = ps.executeQuery();

			Request temp = new Request();
			while(info.next()){
				temp.setStateid(info.getInt(1));
				temp.setReqdate(info.getDate(2));
				temp.setResdate(info.getDate(3));
				temp.setAmt(info.getInt(4));
				temp.setPurpose(info.getString(5));
				temp.setRequesterid(info.getInt(6));
				temp.setResolverid(info.getInt(7));
				temp.setNote(info.getString(8));
				return temp;
			}


		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Request> getEmployeeRequests(int employeeid) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="select * from requests where requesterid=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, employeeid);
			ResultSet info = ps.executeQuery();

			ArrayList<Request> requests = new ArrayList<Request>();
			while(info.next()){
				Request temp = new Request();
				temp.setStateid(info.getInt(1));
				temp.setReqdate(info.getDate(2));
				temp.setResdate(info.getDate(3));
				temp.setAmt(info.getInt(4));
				temp.setPurpose(info.getString(5));
				temp.setRequesterid(info.getInt(6));
				temp.setResolverid(info.getInt(7));
				temp.setNote(info.getString(8));
				requests.add(temp);
			}
			return requests;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String[] getStateNames() {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql1= "select count(*) from statetype";
			Statement statement1 =connection.createStatement();
			ResultSet info1 = statement1.executeQuery(sql1);
			int numStrings=0;
			while(info1.next()){
				numStrings=info1.getInt(1);
			}

			String sql2="select name from statetype";
			Statement statement2 =connection.createStatement();
			ResultSet info2 = statement2.executeQuery(sql2);

			String[] statenames = new String[numStrings];
			int i=0;
			while(info2.next()){
				statenames[i]=info2.getString(1);
				i++;
			}
			return statenames;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void addEmployee(String email, String pw, String fn, String ln, int ismanager) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="insert into employee(email,password,firstname,lastname,ismanager)"
				+ "values(?,?,?,?,?)";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setInt(5, ismanager);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void addRequest(int amt, String purpose, int requesterid) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="insert into requests(amt,purpose,requesterid"
				+ "values(?,?,?)";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, amt);
			ps.setString(2, purpose);
			ps.setInt(3, requesterid);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateRequest(int requestid, int resolverid,String note, boolean approve) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql="update request set resolver id=?,stateid=?,note=? where requestid=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, resolverid);
			if(approve){
				ps.setInt(2,2);//sets to approved stateid
			}else{
				ps.setInt(2, 3);//sets to denied stateid
			}
			ps.setString(3, note);
			ps.setInt(4, requestid);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


}
