package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Customer;
import com.ex.util.ConnectionUtil;

public class DaoImpl {
	public void addOrder(int cust_id, double total){
		
		try(Connection connection= ConnectionUtil.getConnection();){
			String sql = "insert into demo_orders(customer_id,order_total) "
					+"values("+cust_id+","+total+")";
			Statement statement = connection.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: "+numRowsAffected);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	/*
	 *PREPARED STATEMENT used to update
	 *adds customer to demo_customers table
	 */
	public void addCustomer(String fn, String ln, String state, double credit, String email){
		
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql="INSERT INTO demo_customers"
					+"(cust_first_name,cust_last_name,"
					+ "cust_state,credit_limit,"
					+ "cust_email)"
					+"values(?,?,?,?,?)";
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setString(1, fn);
				ps.setString(2, ln);
				ps.setString(3, state);
				ps.setDouble(4, credit);
				ps.setString(5, email);
				
				int num=ps.executeUpdate();
				System.out.println("num rows affected "+num);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/*
	 * PREPARED STATEMENT TO EXECUTE QUERY
	 * 
	 */
		
	public Customer getCustomerById(int id){
		Customer c=new Customer();
		
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from demo_customers where customer_id=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet info=ps.executeQuery();
			
			//id,fn,ls,state,credit,email
			while(info.next()){//moves the cursor row down
				//these move the column across
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}
	public ArrayList<Customer> getAllCustomers(){
		Customer c=new Customer();
		ArrayList<Customer> Customers=new ArrayList<Customer>();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from demo_customers";
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet info=ps.executeQuery();
			
			//id,fn,ls,state,credit,email
			while(info.next()){//moves the cursor row down
				//these move the column across
				c=new Customer();
				c.setId(info.getInt(1));
				c.setFn(info.getString(2));
				c.setLn(info.getString(3));
				c.setState(info.getString(4));
				c.setCredit(info.getDouble(5));
				c.setEmail(info.getString(6));
				Customers.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Customers;
	}
	
	/*
	 * CALLABLE STATEMENT
	 */
	public void createOrder(Customer c,double total){
		int c_id=c.getId();
		try(Connection connect = ConnectionUtil.getConnection();){
			String addOrder = "{call create_order(?,?)}";
			
			CallableStatement cs = connect.prepareCall(addOrder);
			cs.setInt(1, c_id);
			cs.setDouble(2, total);			
			int num = cs.executeUpdate();
			System.out.println(num+"rows inserted");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateCustomer(int id, String fn, String ln, String state, double credit, String email){
		updateCustomerFirstName(id,fn);
		updateCustomerLastName(id,ln);
		updateCustomerState(id,state);
		updateCustomerCredit(id,credit);
		updateCustomerEmail(id,email);
	}
	
	public void updateCustomerFirstName(int id, String fn){		
		
		System.out.println("got in");
		
		try(Connection connect2 = ConnectionUtil.getConnection();){

			System.out.println("did");
			String sql2="update demo_customers set cust_first_name='derp'  where customer_id=1000";
			PreparedStatement ps2 = connect2.prepareStatement(sql2);
//			ps2.setString(1,fn);
//			ps2.setInt(2,id);

			System.out.println("did");
			int num=ps2.executeUpdate();
			System.out.println(num);
		}catch(SQLException e){
			e.printStackTrace();
		}
			
	}
	
	public void updateCustomerLastName(int id, String ln){
		
	}
	public void updateCustomerState(int id ,String State){
		
	}
	public void updateCustomerCredit(int id,double credit){
		
	}
	public void updateCustomerEmail(int id, String email){
		
	}
}