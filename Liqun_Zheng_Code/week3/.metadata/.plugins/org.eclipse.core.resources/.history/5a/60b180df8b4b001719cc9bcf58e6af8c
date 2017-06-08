package com.reim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.reim.util.ConnectionFactory;
import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.pojos.State_type;

public class DaoImpl implements Dao {

	//find requests by an employee id
	@Override
	public ArrayList<Request> findReqByEmpId(int emp_id) {
		 ArrayList<Request> requests = new ArrayList<Request>();
		 Dao dao = new DaoImpl();
		 Request req = new Request();
	        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            String sql = " select r.request_id, r.requester_id, r.resolver_id, r.note,r.purpose, " +
	            " r.state_id, r.opened, r.closed, r.amount from request r " +
	            " inner join employee e " +
	            " on e.employee_id = r.requester_id " +
	            " where e.employee_id = ? ";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, emp_id);

	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
	               
	            	req.setRequest_id(rs.getInt(1));
	            	req.setRequester_id(rs.getInt(2));
	        
	                req.setResolver_id(rs.getInt(3));
	                req.setNote(rs.getString(4));
	                req.setPurpose(rs.getString(5));
	                req.setState(dao.findTypeById(rs.getInt(6)));
	                req.setOpened(rs.getDate(7));
	                req.setClosed(rs.getDate(8));
	                req.setAmount(rs.getDouble(9));
	                requests.add(req);
	                req = new Request();
	               
	            }
	    
	            return requests;

	        } catch (SQLException e) {
				// TODO Auto-generated catch block
	        	e.printStackTrace();
	        }

	        return null;
	}

	
	//Find the employee by username
	@Override
	public Employee findEmpByUname(String uname) {
		// TODO Auto-generated method stub
		
		Employee temp = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from Employee where username = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname.toLowerCase());
			
			ResultSet emp = ps.executeQuery();
			//id, fn, ln, pw, uname
			temp = new Employee();
			
			//assigned each variable of an employee to temp
			while(emp.next()){
				temp.setEmployee_id(emp.getInt(1));
				temp.setFn(emp.getString(2));
				temp.setLn(emp.getString(3));
				temp.setUname(emp.getString(4));
				temp.setPw(emp.getString(5));
				temp.setIs_manager(emp.getInt(6));
				
			}
//			if(temp.getUname()!=null){
//			System.out.println("employee: " +temp.toString());
//			}
			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
		
	}

	
	//find state_type by type_id return state_type object
	@Override
	public State_type findTypeById(int type_id) {
		State_type type = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select name from state_type where state_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, type_id);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email
			while(info.next()){
				type = new State_type(type_id, info.getString(1));
			}
			return type;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	
}
