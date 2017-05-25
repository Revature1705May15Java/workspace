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

public class DaoImpl {
	
	// create_order(c_id IN number, o_t In number)
	// insert into demo_orders(customer_id, order_total) values(c_id, o_t)
	public void addOrder(int custId, double total) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO demo_orders(customer_id, order_total) " +
					"VALUES(" + custId + "," + total + ")";
			
			Statement stmt = conn.createStatement();
			int numRowsAffected = stmt.executeUpdate(sql);
			System.out.println("Num rows affected: " + numRowsAffected);
			
			// auto-commit is ON by default, so don't commit by hand
			//conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomer(String fName, String lName, String state, double creditLimit, String email) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO demo_customers(cust_first_name, cust_last_name, cust_state, credit_limit, cust_email) " +
					"VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fName);
			pstmt.setString(2, lName);
			pstmt.setString(3, state);
			pstmt.setDouble(4, creditLimit);
			pstmt.setString(5, email);
			
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println("Num rows affected: " + numRowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Customer getCustomerById(int id) {
		Customer cust = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_customers WHERE customer_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cust = new Customer(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getString(6)
						);
			}
								
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cust;
	}
	
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> custs = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_customers";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				custs.add(new Customer(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getString(6)
						));
			}
								
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return custs;
	}
	
	public void createOrder(Customer c, double total) {
		int cId = c.getId();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String addOrder = "{call create_order(?,?)}";
			
			CallableStatement cs = conn.prepareCall(addOrder);
			cs.setInt(1, cId);
			cs.setDouble(2,  total);
			int num = cs.executeUpdate();
			System.out.println(num + " rows inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Order> getAllOrdersForCustomer(Customer cust) {
		ArrayList<Order> orders = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_orders " +
					"INNER JOIN demo_customers ON demo_orders.customer_id=demo_customers.customer_id " +
					"WHERE demo_customers.customer_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cust.getId());
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orders.add(new Order(
						rs.getInt(1),
						rs.getDate(4),
						cust,
						rs.getDouble(3)
						));
			}
								
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
	
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM demo_orders";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			DaoImpl dao = new DaoImpl();
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orders.add(new Order(
						rs.getInt(1),
						rs.getDate(4),
						dao.getCustomerById(rs.getInt(2)),
						rs.getDouble(3)
						));
			}
								
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
	
	
	public void updateCustomer(Customer cust) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE demo_customers SET " +
					"cust_first_name=?," +
					"cust_last_name=?," +
					"cust_state=?," +
					"credit_limit=?," +
					"cust_email=? " +
					"WHERE customer_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cust.getfName());
			pstmt.setString(2, cust.getlName());
			pstmt.setString(3, cust.getState());
			pstmt.setDouble(4, cust.getCredit());
			pstmt.setString(5, cust.getEmail());
			pstmt.setInt(6, cust.getId());
			
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println("Num rows affected: " + numRowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
