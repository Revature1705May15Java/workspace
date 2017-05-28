package com.ex.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojo.Customer;
import com.ex.pojo.Order;
import com.ex.util.ConnectionUtil;

public class DecImpl 
{
	/*
	public void addOrder (int cust_id, double total)
	{
		try (Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "insert into demo_orders(customer_id,order_total)"
					+ "values (" + cust_id + "," + total + ")";
			Statement statement = connect.createStatement();
			
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Rows affected " + numRowsAffected);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	*/
	
	public void createOrder (Customer c,double total)
	{
		int c_id = c.getId();
		
		try(Connection cconnect = ConnectionUtil.getConnection();)
		{
			String addOrder = "{call create_order(?,?)}";
			
			CallableStatement cs = cconnect.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2, total);
			
			int num = cs.executeUpdate();
			System.out.println(num + "rows inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addCustomer (String fn, String ln,String state,double credit, String email)
	{
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "INSERT INTO DEMO_CUSTOMERS (CUST_FIRST_NAME,"
					+"CUST_LAST_NAME,CUST_STATE,CUST_LIMIT,CUST_EMAIL)"
					+"VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = connect.prepareStatement(sql);	
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			
			int numRowsAffected = ps.executeUpdate();
			System.out.println("Rows affected "+numRowsAffected);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Customer getCustomerById (int id)
	{
		Customer c = new Customer();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from demo_customers where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
			}
			
			return c;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ERROR");
		return null;
		
	}
	
	public ArrayList<Customer> getAllCustomers ()
	{
		Customer c;
		
		
		ArrayList <Customer> cl = new ArrayList<Customer> ();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from demo_customers";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				c = new Customer();
				
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
				
				
				cl.add(c);
			}
			
			return cl;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ERROR");
		return null;
		
	}
	
	public ArrayList<Order> getAllOrders ()
	{
		Order o;
		Customer c;
		
		ArrayList <Order> ol = new ArrayList<Order> ();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from demo_orders";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				o = new Order();
				
				o.setId(info.getInt(1));
				c = getCustomerById(info.getInt(2));
				o.setC(c);
				o.setTotal(info.getDouble(3));
					
				ol.add(o);
			}
			
			return ol;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ERROR");
		return null;
	}
	
	public ArrayList<Order> getOrdersByC (Customer c)
	{
		Order o;
		Customer a;
		int cID = c.getId();
		
		ArrayList <Order> ol = new ArrayList<Order> ();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from demo_orders where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, cID);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				o = new Order();
				
				o.setId(info.getInt(1));
				a = getCustomerById(info.getInt(2));
				o.setC(a);
				o.setTotal(info.getDouble(3));
					
				ol.add(o);
			}
			
			return ol;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ERROR");
		return null;
	}
	
	public void updateCustomer (Customer c)
	{
		
		int id = c.getId();
		String fn = c.getFn();
		String ln = c.getLn();
		String state= c.getState();
		String email = c.getEmail();
		double credit = c.getCredit();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "Update DEMO_CUSTOMERS SET CUST_FIRST_NAME = ?,"
					+"CUST_LAST_NAME = ? ,CUST_STATE = ?,CUST_LIMIT = ?,CUST_EMAIL = ?"
					+"WHERE CUSTOMER_ID = ?";
			
			PreparedStatement ps = connect.prepareStatement(sql);	
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			ps.setInt(6, id);
			
			int numRowsAffected = ps.executeUpdate();
			System.out.println("Rows affected "+numRowsAffected);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

