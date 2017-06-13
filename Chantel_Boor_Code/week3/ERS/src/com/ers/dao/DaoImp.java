package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.RequestType;
import com.ers.pojos.Requests;
import com.ers.util.ConnectionFactory;

public class DaoImp implements DAO 
{
	
	public Employee getEmployee(String email)
	{
		
		Employee e = new Employee();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "select * from employee where email = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				e.setEmployeeId(info.getInt(1));
				e.setfName(info.getString(2));
				e.setlName(info.getString(3));
				e.setIsManager(info.getInt(4));
				e.setEmail(info.getString(5));
				e.setPass(info.getString(6));
			}
			
			
			if(email == null)
			{
				e.setEmployeeId(0);
			}
			
			return e;
		} 
		catch (SQLException sq) 
		{
			// TODO Auto-generated catch block
			sq.printStackTrace();
		}
		
		System.out.println("ERROR");
		e.setEmployeeId(0);
		return e;
	}
	
	public int addRequest(int type, double amount, String purpose, int requster) 
	{
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();)
		{
			
			String sql = " insert into requests (type, amount, purpose, requester)"
						+ "values (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, type);
			ps.setDouble(2, amount);
			ps.setString(3, purpose);
			ps.setInt(4, requster);
			
			int num = ps.executeUpdate();
			
			
			return num;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	//gets all requests related to a specific employee
	public ArrayList<Requests> getR(int id)
	{
		ArrayList<Requests> reqs = new ArrayList<Requests>();
		Requests r;
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "select * from Requests where REQUESTER = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				r = new Requests();
				
				r.setRequestId(info.getInt(1));

				RequestType t = getType(info.getInt(2));
				r.setType(t);
				
				r.setAmount(info.getDouble(3));
				r.setPurpose(info.getString(4));
				r.setRequested(info.getDate(5));
				r.setResolved(info.getDate(6));
				r.setReqester(info.getInt(7));
				r.setResolver(info.getInt(8));
				r.setNote(info.getString(9));
					
				reqs.add(r);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reqs;
		
	}
	
	//gets all requests that are in database for managers
	public ArrayList<Requests> getAllR()
	{
		ArrayList<Requests> reqs = new ArrayList<Requests>();
		Requests r;
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "select * from Requests";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				r = new Requests();
				
				r.setRequestId(info.getInt(1));

				RequestType t = getType(info.getInt(2));
				r.setType(t);
				
				r.setAmount(info.getDouble(3));
				r.setPurpose(info.getString(4));
				r.setRequested(info.getDate(5));
				r.setResolved(info.getDate(6));
				r.setReqester(info.getInt(7));
				r.setResolver(info.getInt(8));
				r.setNote(info.getString(9));
					
				reqs.add(r);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reqs;
		
	}
	
	public RequestType getType (int i)
	{
		RequestType temp = new RequestType();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "select * from stateType where STATEID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, i);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				
				temp.setTypeId(info.getInt(1));
				temp.setName(info.getString(2));
				
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}


}
