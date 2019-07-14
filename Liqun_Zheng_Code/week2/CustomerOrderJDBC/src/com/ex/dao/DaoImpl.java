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
import com.ex.util.ConnectionUtil;

public class DaoImpl {
/*
 * STATEMENT to update
 * adds order 
 */
	
	public void addOrder(int cust_id, double total){
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "insert into demo_orders(customer_id, order_total) "+
						"values("+ cust_id + ", " + total + ")";
			Statement statement = connection.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: "+ numRowsAffected);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*
 * Callable statement	
 */
	public void createOrder(Customer c, double total){
		int c_id = c.getId();
		try(Connection connection = ConnectionUtil.getConnection();){
			String addOrder = "{call create_order(?, ?)}";
			CallableStatement cs = connection.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2, total);
			int num = cs.executeUpdate();
			System.out.println(num + "rows inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *Prepared statement used to update
	 *add customer to demo_custmoer table
	 */
	public void addCustomer(String fn, String ln, String state, double credit, String email){
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "insert into demo_customers(cust_first_name, cust_last_name," + ""
					+ "cust_state, credit_limit, cust_email) values(?,?, ?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			
			int num = ps.executeUpdate();
			System.out.println("num rows affected " + num);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * PREPARED STATEMENT TO EXECUTE QUERY
	 */
	public Customer getCustomerById(int id){
		Customer c = new Customer();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from demo_customers where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email
			while(info.next()){
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
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
		System.out.println("ERROR!");
		return null;
				
	}
	
	//return all customers
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer c = new Customer();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from demo_customers";
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email
			while(info.next()){
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
				list.add(c);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR!");
		return null;
				
	}
	
	//return all orders
	public ArrayList<Order> getOrders(){
		ArrayList<Order> list = new ArrayList<Order>();
		Order c = new Order();
		DaoImpl daoImpl = new DaoImpl();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from demo_orders";
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			//orderid cust_id total timestamp
			while(info.next()){
				c.setId(info.getInt(1));
				c.setSt(daoImpl.getCustomerById((info.getInt(2))));
				c.setTotal(info.getDouble(3));
				c.setDateOrdered(info.getDate(4));
				list.add(c);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR!");
		return null;
				
	}
	//update customers
	public Customer updateCustomer(int id, String fn, String ln, String state, double credit, String email){
		
		DaoImpl daoImpl = new DaoImpl();
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql ="update DEMO_CUSTOMERS "+
					"set CUST_FIRST_NAME = ?, CUST_LAST_NAME = ?, CUST_STATE=?, "+
					 "CREDIT_LIMIT = ?,  CUST_EMAIL= ? "+
					"where CUSTOMER_ID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, state);
			ps.setDouble(4, credit);
			ps.setString(5, email);
			ps.setInt(6, id);
			
			int num = ps.executeUpdate();
			System.out.println("num rows affected " + num);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoImpl.getCustomerById(id);
	}
	
	//return all orders by customer
	public ArrayList<Order> getOrdersByCustomer(Customer cust){
		ArrayList<Order> list = new ArrayList<Order>();
		Order c = new Order();
		DaoImpl daoImpl = new DaoImpl();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from demo_orders where customer_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, cust.getId());
			ResultSet info = ps.executeQuery();
			//orderid cust_id total timestamp
			while(info.next()){
				c.setId(info.getInt(1));
				c.setSt(daoImpl.getCustomerById((info.getInt(2))));
				c.setTotal(info.getDouble(3));
				c.setDateOrdered(info.getDate(4));
				list.add(c);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR!");
		return null;
				
	}
}


 