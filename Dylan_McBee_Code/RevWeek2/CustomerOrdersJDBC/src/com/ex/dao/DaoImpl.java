package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Customer;
import com.ex.pojos.Order;
import com.ex.util.ConnectionUtil;

public class DaoImpl {
	/*
	 * STATEMENT to update adds order to demo_orders table
	 */
	public void addOrder(int cust_id, double total) {

		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "insert into demo_orders(customer_id, order_total) values(" + cust_id + ", " + total + ")";
			Statement statement = connection.createStatement();

			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: " + numRowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/*
	 * PREPARED STATEMENT used to update adds customer to demo_customers table
	 */

	public void addCustomer(String fn, String ln, String state, double credit, String email) {

		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "insert into demo_customers (cust_first_name, cust_last_name, cust_state, credit_limit, cust_email) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);

			int num = ps.executeUpdate();
			System.out.println("Num rows affected: " + num);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * PREPARED STATEMENT TO EXECUTE QUERY
	 */
	public Customer getCustomerById(int id) {
		Customer c = new Customer();

		try (Connection connect = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_customers where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet info = ps.executeQuery();

			// id, fn, ln, state, credit, email

			while (info.next()) {
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");

		return null;

	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();

		try (Connection connect = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_customers";
			PreparedStatement ps = connect.prepareStatement(sql);

			ResultSet info = ps.executeQuery();

			// id, fn, ln, state, credit, email

			while (info.next()) {
				Customer c = new Customer();
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
				customers.add(c);
			}
			return customers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");

		return null;
	}
	/*
	 * CALLABLE STATEMENT
	 */

	public void createOrder(Customer c, double total) {
		int c_id = c.getId();
		try (Connection connect = ConnectionUtil.getConnection();) {
			String addOrder = "{call create_order(?, ?)}";

			CallableStatement cs = connect.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2, total);

			int num = cs.executeUpdate();
			System.out.println(num + " rows inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		try (Connection connect = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_orders";
			PreparedStatement ps = connect.prepareStatement(sql);

			ResultSet info = ps.executeQuery();

			// order id, customer id, order total, order timestamp
			while (info.next()) {
				Customer c = new Customer();
				Order o = new Order();
				o.setId(info.getInt(1));
				c.setId(info.getInt(1));
				o.setCust(c);
				o.setTotal(info.getDouble(3));
				o.setDateOrdered(info.getDate(4));
				orders.add(o);
			}
			return orders;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");

		return null;
	}
	public void updateCustomer(int id, String fn, String ln, String state, double credit, String email){
		try (Connection connect = ConnectionUtil.getConnection();){
			String sql = "update demo_customers set cust_first_name = ?, cust_last_name = ?, cust_state = ?, credit_limit = ?, cust_email = ?"
					+ " where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			ps.setInt(6, id);
			int num = ps.executeUpdate();
			System.out.println("Num rows affected: " + num); 	
			// id, fn, ln, state, credit, email
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Order> getAllOrdersByCustomer(Customer customer){
		List<Order> orders = new ArrayList<Order>();
		int c_id = customer.getId();
		try (Connection connect = ConnectionUtil.getConnection();) {
			String sql = "select * from demo_orders where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, c_id);
			ResultSet info = ps.executeQuery();

			// order id, customer id, order total, order timestamp
			while (info.next()) {
				Customer c = new Customer();
				Order o = new Order();
				o.setId(info.getInt(1));
				c.setId(c_id);
				o.setCust(c);
				o.setTotal(info.getDouble(3));
				o.setDateOrdered(info.getDate(4));
				orders.add(o);
			}
			return orders;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");
		return null;
	}
}