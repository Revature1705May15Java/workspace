package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.ex.pojos.Customer;
import com.ex.pojos.Order;
import com.ex.util.ConnectionUtil;

/*
 * Manipulating the ExamplesDB database
 */
public class DaoImpl {
	/**
	 * Add an order record to the demo_orders table
	 * @param cust_id
	 * @param total
	 */
	public void addOrder(int cust_id, double total) {
		// Creates a connection to the database
		try (Connection connection = ConnectionUtil.getConnection();) {
			// SQL query for inserting a record into the demo_orders table
			String sql = "INSERT INTO demo_orders (customer_id, order_total)"
						 + "VALUES (" + cust_id + ", " + total + ")";
			
			// Creates a Statement object for sending SQL statements to the database
			Statement statement = connection.createStatement();
			
			// Executes the given SQL statement
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: " + numRowsAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a customer record to the demo_customers table
	 * @param cust_first_name
	 * @param cust_last_name
	 * @param cust_street_address1
	 * @param cust_street_address2
	 * @param cust_city
	 * @param cust_state
	 * @param cust_postal_code
	 * @param phone_number1
	 * @param phone_number2
	 * @param credit_limit
	 * @param cust_email
	 */
	public void addCustomer(String cust_first_name, String cust_last_name, String cust_street_address1, String cust_street_address2, String cust_city, String cust_state, String cust_postal_code, String phone_number1, String phone_number2, double credit_limit, String cust_email) {
		// Creates a connection to the database
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO demo_customers "
						+ "(cust_first_name, cust_last_name, cust_street_address1, cust_street_address2, cust_city, cust_state, cust_postal_code, phone_number1, phone_number2, credit_limit, cust_email)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cust_first_name);
			ps.setString(2, cust_last_name);
			ps.setString(3, cust_street_address1);
			ps.setString(4, cust_street_address2);
			ps.setString(5, cust_city);
			ps.setString(6, cust_state);
			ps.setString(7, cust_postal_code);
			ps.setString(8, phone_number1);
			ps.setString(9, phone_number2);
			ps.setDouble(10, credit_limit);
			ps.setString(11, cust_email);
			
			int row = ps.executeUpdate();
			System.out.println("Num rows affected " + row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a Customer by id
	 * @param id
	 * @return a Customer object
	 */
	public Customer getCustomerById(int id) {
		Customer c = new Customer();
		// Creates a connection to the database
		try (Connection connection = ConnectionUtil.getConnection();) {
			// Query to select the record with the specified id
			String sql = "SELECT * FROM demo_customers WHERE customer_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			while (info.next()) {
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
				c.setCredit(info.getDouble(11));
				c.setEmail(info.getString(12));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}
	
	/**
	 * Gets all the Customers
	 * @return a list of Customers
	 */
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		// Creates a connection to the database
		try (Connection connection = ConnectionUtil.getConnection();) {
			// Query to select the record with the specified id
			String sql = "SELECT * FROM demo_customers";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			while (info.next()) {
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
				c.setCredit(info.getDouble(11));
				c.setEmail(info.getString(12));
				customers.add(c);
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}
	
	/**
	 * Uses a Callable Statement to call a procedure in sql to 
	 * create an Order in the demo_orders table of the ExamplesDB database
	 * @param c
	 * @param total
	 */
	public void createOrder(Customer c, double total) {
		int c_id = c.getId();
		try (Connection connect = ConnectionUtil.getConnection();) {
			String addOrder = "{call create_order(?, ?)}";
			
			CallableStatement cs = connect.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2,  total);
			
			int row = cs.executeUpdate();
			System.out.println(row + " rows inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get all of the Orders 
	 * @return an arraylist of orders
	 */
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		// Creates a connection to the database
		try (Connection connection = ConnectionUtil.getConnection();) {
			// Query to select the record with the specified id
			String sql = "SELECT * FROM demo_orders";
			
			// Creates a PreparedStatement object for sending parameterized SQL statements to the database
			PreparedStatement ps = connection.prepareStatement(sql);
			
			// Executes the SQL query in this PreparedStatement object and returns the ResultSet object generated by the query
			ResultSet info = ps.executeQuery();
			
			// Sets all the fields of the Order and adds it to the list
			while (info.next()) {
				Customer c = new Customer();
				Order o = new Order();
				o.setId(info.getInt(1));
				c.setId(info.getInt(2));
				o.setCust(c);
				o.setTotal(info.getDouble(3));
				o.setDateOrdered(info.getDate(4));
				orders.add(o);
			}
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}
	
	/**
	 * Gets all of the orders that a specific customer has.
	 * @param cust_id
	 * @return the list of orders
	 */
	public ArrayList<Order> getAllOrdersByCustomer(int cust_id) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		// Creates a connection to the database
		try (Connection connection = ConnectionUtil.getConnection();) {
			// Query to select the orders by the specific cust_id
			String sql = "SELECT * FROM demo_orders WHERE customer_id = ?";
			
			// Creates a PreparedStatement object for sending parameterized SQL statements to the database
			PreparedStatement ps = connection.prepareStatement(sql);
			
			// Fills in the ? in the sql query with cust_id
			ps.setInt(1, cust_id);
			
			// Executes the SQL query in this PreparedStatement object and returns the ResultSet object generated by the query
			ResultSet info = ps.executeQuery();
			
			// Sets all the fields of the Order and adds it to the list
			while (info.next()) {
				Customer c = new Customer();
				Order o = new Order();
				o.setId(info.getInt(1));
				c.setId(info.getInt(2));
				o.setCust(c);
				o.setTotal(info.getDouble(3));
				o.setDateOrdered(info.getDate(4));
				orders.add(o);
			}
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}
	
	public void updateCustomer(int cust_id, HashMap updateFields) {
		// Creates a connection to the database
		try (Connection connect = ConnectionUtil.getConnection();) {
			// Set up the sql query
			String sql = "UPDATE demo_customers SET ";
			Set<String> keys = updateFields.keySet();
			for (String key : keys) {
				sql += key + " = ?, ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += " WHERE customer_id = ?";
			
			// Creates a PreparedStatement object for sending parameterized SQL statements to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			
			// Fill in the sql statement with the current values for the attributes
			int count = 1;
			for (String key : keys) {
				if (key.equals("credit_limit"))
					ps.setDouble(count, (double) updateFields.get(key)); 
				else
					ps.setString(count, (String) updateFields.get(key));
				count++;
			}
			ps.setInt(count, cust_id);
			
			// Execute the query
			int row = ps.executeUpdate();
			System.out.println(row + " row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
