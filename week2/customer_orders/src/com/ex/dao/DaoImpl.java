package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Customer;
import com.ex.pojos.Order;
import com.ex.util.connectionUtil;

public class DaoImpl {
	
	public void addOrder(int cust_ID, double total){
		try(Connection connection = connectionUtil.getConnection();){
			
			String sql = "INSERT INTO demo_orders(customer_id, order_total) "
					   + "VALUES(" + cust_ID + ", " + total + ")";
			
			Statement statement = connection.createStatement();
			
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num of rows affected: " + numRowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCustomer(String fn, String ln, String state, double credit, String email){
		try(Connection connection = connectionUtil.getConnection();){
			
			String sql = "INSERT INTO DEMO_CUSTOMERS(cust_first_name,cust_last_name,cust_state,credit_limit,cust_email)"
						+ "VALUES (?,?,?,?,?)";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);// this set always goes by the parameter position, not the type so
			ps.setString(2, ln);// even though the 4th is a double and the first double encountered
			ps.setString(3, state); // the index is still as the 4th parameter
			ps.setDouble(4, credit);
			ps.setString(5, email);
			
			int numRowsAffected = ps.executeUpdate();
			System.out.println("Num of Rows Affected: " + numRowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Customer getCustomerById(int id){
		Customer c = new Customer();
		
		try(Connection connection = connectionUtil.getConnection();){
			String sql = "SELECT * FROM demo_customers WHERE customer_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()){ // this will take into account if multiple rows are returned. This also puts the cursor at
				c.setId(info.getInt(1)); // the first position (first row and column) of the table. The cursor's first .next 
				c.setFn(info.getString(2)); // call is actually out of the reseltset.
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
			}
			
			return c;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Customer not found.");
		return c;
	}
	
	
	public Customer updateCustomerName(String fn, String ln, int id){
		Customer c = new Customer();
		
		try(Connection connection = connectionUtil.getConnection();){
			String sql = "UPDATE demo_customers SET cust_first_name = ?, cust_last_name = ? WHERE customer_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setInt(3, id);

			int num = ps.executeUpdate();
			System.out.println("Num of Rows Updated: " + num);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c = getCustomerById(id);
		return c;
	}
	
	public ArrayList<Customer> getAllCustomers(){
		ArrayList<Customer> c = new ArrayList<Customer>();
		Customer temp = new Customer();
		
		try(Connection connection = connectionUtil.getConnection();){
			String sql = "SELECT * FROM demo_customers";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			int i = 0;
			while(info.next()){ // this will take into account if multiple rows are returned. This also puts the cursor at
				// the first position (first row and column) of the table. The cursor's first .next call is actually out of the reseltset.
				temp = new Customer();
				temp.setId(info.getInt(1)); // the first position (first row and column) of the table. The cursor's first .next 
				temp.setFn(info.getString(2)); // call is actually out of the reseltset.
				temp.setLn(info.getString(3));
				temp.setState(info.getString(4));
				temp.setCredit(info.getDouble(5));
				temp.setEmail(info.getString(6));
				c.add(i, temp);
				i++;	
				
			}
			
			return c;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Customer not found.");
		return null;
	}
	
	public ArrayList<Order> getAllOrders(){
		ArrayList<Order> c = new ArrayList<Order>();
		Order temp;
		
		try(Connection connection = connectionUtil.getConnection();){
			String sql = "SELECT * FROM demo_orders";
			
			PreparedStatement ps2 = connection.prepareStatement(sql);
			
			ResultSet infoIn = ps2.executeQuery();
			int i = 0;
			while(infoIn.next()){
				temp = new Order();
				temp.setId(infoIn.getInt(1));
				temp.setCust(getCustomerById(infoIn.getInt(2)));
				temp.setTotal(infoIn.getInt(3));
				temp.setDate(infoIn.getDate(4));
				c.add(i, temp);
				i++;	
			}
			
			return c;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Customer not found.");
		return null;
	}
	
	public ArrayList<Order> getAllOrdersByCustomer(int cust_id){
		ArrayList<Order> c = new ArrayList<Order>();
		Order temp;
		
		try(Connection connection = connectionUtil.getConnection();){
			String sql = "SELECT * FROM demo_orders WHERE customer_ID = ?";
			
			PreparedStatement ps2 = connection.prepareStatement(sql);
			ps2.setInt(1, cust_id);
			ResultSet infoIn = ps2.executeQuery();
			int i = 0;
			while(infoIn.next()){
				temp = new Order();
				temp.setId(infoIn.getInt(1));
				temp.setCust(getCustomerById(infoIn.getInt(2)));
				temp.setTotal(infoIn.getInt(3));
				temp.setDate(infoIn.getDate(4));
				c.add(i, temp);
				i++;	
			}
			
			return c;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Customer not found.");
		return null;
	}
	
	public void createOrder(Customer c, double total){
		int c_id = c.getId();
		
		try(Connection connection = connectionUtil.getConnection();){
			String addOrder = "{call create_order(?, ?)}"; // brackets not needed to create the order in
											// the database, however the output here will be incorrect, it will say 0 rows.
			CallableStatement cs = connection.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2, total);
			
			int num = cs.executeUpdate();
			System.out.println("Rows Inserted: " + num);
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
