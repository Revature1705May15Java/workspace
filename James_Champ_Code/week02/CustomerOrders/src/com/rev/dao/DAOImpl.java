package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.Customer;
import com.rev.pojos.Order;
import com.rev.util.ConnectionUtil;

public class DAOImpl implements DAO{
	
	// TODO: Change double to BigDecimal
	public void addOrder(int customerId, double orderTotal) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = 	"INSERT INTO demo_orders(customer_id, order_total) " +
							"VALUES (" + customerId + ", " + orderTotal + ")";
			Statement statement = conn.createStatement();
			
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: " + numRowsAffected);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomer(String fn, String ln, String state, double credit, String email) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO demo_customers " +
					"(cust_first_name, cust_last_name, cust_state, credit_limit, cust_email) " +
					"VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			
			int num = ps.executeUpdate();
			System.out.println("Num rows affected: " + num);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Customer getCustomerById(int id) {
		Customer c = new Customer();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_customers " +
						"WHERE customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				c.setId(info.getInt(1));
				c.setFirstName(info.getString(2));
				c.setLastName(info.getString(3));
				c.setAddress1(info.getString(4));
				c.setAddress2(info.getString(5));
				c.setCity(info.getString(6));
				c.setState(info.getString(7));
				c.setPostalCode(info.getString(8));
				c.setPhone1(info.getString(9));
				c.setPhone2(info.getString(10));
				c.setCreditLimit(info.getDouble(11));
				c.setEmail(info.getString(12));
			}
			
			return c;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Something went wrong");
		return null;
	}
	
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> results = new ArrayList<Customer>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_customers";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				Customer c = new Customer();
				c.setId(info.getInt(1));
				c.setFirstName(info.getString(2));
				c.setLastName(info.getString(3));
				c.setAddress1(info.getString(4));
				c.setAddress2(info.getString(5));
				c.setCity(info.getString(6));
				c.setState(info.getString(7));
				c.setPostalCode(info.getString(8));
				c.setPhone1(info.getString(9));
				c.setPhone2(info.getString(10));
				c.setCreditLimit(info.getDouble(11));
				c.setEmail(info.getString(12));
				
				results.add(c);
			}
			
			return results;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Error occurred");
		return null;
	}
	
	public boolean createOrder(Customer c, double total) {
		int c_id = c.getId();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{call create_order(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, c_id);;
			cs.setDouble(2, total);
			
			int num = cs.executeUpdate();
			System.out.println(num + " rows inserted.");
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> results = new ArrayList<Order>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_orders";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Order order = new Order();
				
				order.setOrderId(rs.getInt(1));
				order.setCustomerId(getCustomerById(rs.getInt(2)));
				order.setTotal(rs.getDouble(3));
				order.setTimestamp(rs.getDate(4));
				
				results.add(order);
			}
			
			return results;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Order> getOrdersByCustomer(Customer c) {
		ArrayList<Order> results = new ArrayList<Order>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_orders " +
						"WHERE customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				
				order.setOrderId(rs.getInt(1));
				order.setCustomerId(getCustomerById(rs.getInt(2)));
				order.setTotal(rs.getDouble(3));
				order.setTimestamp(rs.getDate(4));
				
				results.add(order);
			}
			
			return results;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean updateCustomer(Customer c) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL update_customer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, c.getId());
			cs.setString(2, c.getFirstName());
			cs.setString(3, c.getLastName());
			cs.setString(4, c.getAddress1());
			cs.setString(5, c.getAddress2());
			cs.setString(6, c.getCity());
			cs.setString(7, c.getState());
			cs.setString(8, c.getPostalCode());
			cs.setString(9, c.getPhone1());
			cs.setString(10, c.getPhone2());
			cs.setDouble(11, c.getCreditLimit());
			cs.setString(12, c.getEmail());
			
			int numberChanged = cs.executeUpdate();
			System.out.println(numberChanged + " rows changed.");
			
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
