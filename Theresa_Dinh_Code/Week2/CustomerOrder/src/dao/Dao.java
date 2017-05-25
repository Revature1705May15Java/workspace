package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectionUtil.ConnectionUtil;
import pojos.Customer;
import pojos.Order;

// 

public class Dao 
{
	// statement to add order to demo_orders table
	public void addOrder(int custID, double total)
	{
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "INSERT INTO DEMO_ORDERS(CUSTOMER_ID, ORDER_TOTAL)"
					+ " VALUES(" + custID + ", " + total + ")";
			Statement statement = connect.createStatement(); 
			
			int numRowsAffected = statement.executeUpdate(sql); 
			System.out.println("Rows affected " + numRowsAffected); 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//prepared statement used to update ?????????????????
	// add customer to demo-customers table
	public void addCustomer(String fn, String ln, String state, 
			double credit, String email)
	{
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			// fn, ln, state, credit, mail
			String sql = "INSERT INTO DEMO_CUSTOMERS(CUST_FIRST_NAME, CUST_LAST_NAME, "
					+ "CUST_STATE, CREDIT_LIMIT, CUST_EMAIL)VALUES"
					+ "(?, ?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql); 
			ps.setString(1, fn);
			ps.setString(2, ln); 
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			
			int numRowsAffected = ps.executeUpdate(sql); 
			System.out.println("Rows affected " + numRowsAffected);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	// prepared statement to retrieve customer by ID 
	public Customer getCustomerByID(int id)
	{
		Customer c = new Customer(); 
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from DEMO_CUSTOMERS WHERE CUSTOMER_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery(); 
			
			// id, fn, ln, state, credit, mail
			while(info.next())
			{
				c.setID(info.getInt(1));
				c.setFirstName(info.getString(2));
				c.setLastName(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(5));
			}
			return c;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("ERROR");
		return null; 
	}
	
	public ArrayList<Customer> getAllCustomers()
	{
		ArrayList<Customer> list = new ArrayList<Customer>(); 
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "SELECT * FROM DEMO_CUSTOMERS";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Customer c = new Customer(); 
				c.setID(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setState(rs.getString(4));
				c.setCredit(rs.getDouble(5));
				c.setEmail(rs.getString(6));
				list.add(c); 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list; 
	}
	
	public void getAllCustomers1()
	{ 		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from DEMO_CUSTOMERS"; 
			PreparedStatement ps = connect.prepareStatement(sql); 
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// id, fn, ln, state, credit, mail
				Customer c = new Customer(); 
				c.setID(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setState(rs.getString(4));
				c.setCredit(rs.getDouble(5));
				c.setEmail(rs.getString(6));
				System.out.println(c.toString());
				// missing last row? 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	// calls the createOrder procedure to create an order for a
	// given Customer 
	public void createOrder(Customer c, double total)
	{
		int c_id = c.getId(); 
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String addOrder = "{call create_order(?, ?)}";
			
			CallableStatement cs = connect.prepareCall(addOrder); 
			cs.setInt(1, c_id);
			cs.setDouble(2, total);
			
			int num = cs.executeUpdate(); 
			System.out.println("Rows affected " + num);
		}
		catch(SQLException e)
		{
			e.printStackTrace(); 
		}
	}
	
	// returns an ArrayList of all Orders in the db
	public ArrayList<Order> getAllOrders()
	{
		ArrayList<Order> list = new ArrayList<Order>(); 
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "SELECT * FROM DEMO_ORDERS"; 
			PreparedStatement ps = connect.prepareStatement(sql); 
			
			ResultSet rs = ps.executeQuery(); 
			
			// orderid, customer id, order total, order timestamp 
			while(rs.next())
			{
				Order o = new Order(); 
				o.setId(rs.getInt(1));
				o.setCust(getCustomerByID(rs.getInt(2)));
				o.setTotal(rs.getDouble(3));
				o.setDateOrdered(rs.getDate(4));
				list.add(o);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list; 
	}
	
	// given a Customer, return all the Orders ever made by the Customer
	// get Customer ID, then retrieve list of all Orders and then 
	// filter to all Orders that share the given Customer ID
//	public ArrayList<Order> getAllOrdersByCustomer(Customer c)
	public ArrayList<Order> getAllOrdersByCustomer(int c)
	{
		ArrayList<Order> list = new ArrayList<Order>(); 
//		int custID = c.getId(); 
//		
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "SELECT * FROM DEMO_ORDERS WHERE CUSTOMER_ID = ?"; 			 
			PreparedStatement ps = connect.prepareStatement(sql); 
//			ps.setInt(1, c.getId());
			ps.setInt(1, c);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				Order o = new Order(); 
				o.setId(rs.getInt(1));
				o.setCust(getCustomerByID(rs.getInt(2)));
				o.setTotal(rs.getDouble(3));
				o.setDateOrdered(rs.getDate(4));
				list.add(o);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list; 
	}
	
	// given a Customer's data, change it to the new data 
	public Customer updateCustomer(Customer old, Customer nc)	
	{
		try(Connection connect = ConnectionUtil.getConnection();)
			{
			String sql = "UPDATE CUSTOMER SET CUST_FIRST_NAME = ?, "
					+ "CUST_LAST_NAME = ?, CUST_STATE = ?, CUST_EMAIL = ? "
					+ "WHERE CUSTOMER_ID = ?"; 
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nc.getFirstName());
			ps.setString(2, nc.getLastName());
			ps.setString(3, nc.getState());
			ps.setString(4, nc.getEmail());
			ps.setInt(5, old.getId());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null; 
	}
}



