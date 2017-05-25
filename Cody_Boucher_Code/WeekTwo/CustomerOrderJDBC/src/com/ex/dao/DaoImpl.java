package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ex.pojos.Customer;
import com.ex.pojos.Order;
import com.ex.util.ConnectionUtil;

public class DaoImpl {
	/*
	 * STATEMENT TO UPDATE
	 * adds order to demo table
	 */
	
	public void addOrder(int customerId, double orderTotal) {
		
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "insert into demo_orders(customer_id, order_total) values(" + customerId + ", " + orderTotal + ")";
			Statement statement = connection.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: " + numRowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * PREPARED STATEMENT used to update
	 * adds customer to demo_customer table
	 */
	public void addCustomer(String fName, String lName, String state, double credit, String email) {
	    try (Connection connection = ConnectionUtil.getConnection();) {
	      String sql = "insert into demo_customers (cust_first_name, cust_last_name, cust_state, credit_limit, cust_email) values (?, ?, ?, ?, ?)";
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, fName);
	      ps.setString(2, lName);
	      ps.setString(3, state);
	      ps.setDouble(4, credit);
	      ps.setString(5, email);

	     int numRowsAffected = ps.executeUpdate();
	      System.out.println("Number of rows affected: " + numRowsAffected);
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	//UPDATE Customer hard coded for now
	public void updateCustomer(String firstName, String lastName, String state, double credit, String email, int id) {
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "update demo_customers set cust_first_name = ?, cust_last_name = ?, cust_state = ?, credit_limit = ?, cust_email = ? where customer_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			ps.setInt(6, id);
			int numRowsAffected = ps.executeUpdate();
			System.out.println("num rows affected: " + numRowsAffected);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * PREPARED STATEMENT TO EXECUTE QUERY
	 */
	
	public Customer getCustomerById(int id) {
		Customer c = new Customer();
		
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_customers where customer_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			//id, fn, ln, state, credit, email
			while( info.next()) {
				c.setId(info.getInt(1));
				c.setFirstName(info.getString(2));
				c.setLastName(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
			}
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}
	
	//get all orders by customer
	public void getCustomerOrders(int id) {
		Order o = new Order();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_orders where customer_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				o.setId(info.getInt(1));
				o.setCustomer(info.getInt(2));
				o.setTotal(info.getDouble(3));
				o.setDateOrder(info.getDate(4));
				System.out.println(o.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//get all orders
	public void getOrders() {
		Order o = new Order();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_orders";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			//orderId, customerId, orderTotal, orderTime
			while(info.next()) {
				o.setId(info.getInt(1));
				o.setCustomer(info.getInt(2));
				o.setTotal(info.getDouble(3));
				o.setDateOrder(info.getDate(4));
				System.out.println(o.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getCustomers() {
		Customer c = new Customer();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_customers";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			//id, fn, ln, state, credit, email
			while( info.next()) {
				c.setId(info.getInt(1));
				c.setFirstName(info.getString(2));
				c.setLastName(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
				System.out.println(c.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	//CALLABLE STATEMENT
	

	public void createOrder(Customer c, double total) {
		int c_id = c.getId();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String addOrder = "{call create_order(?, ?)}";
			
			CallableStatement cs = connection.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2, total);
			
			int num = cs.executeUpdate();
			System.out.println(num + "rows inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
