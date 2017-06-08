package com.reim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.reim.util.ConnectionFactory;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

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
	
	//add a new request for employee u, pass in add purpose and amount
	@Override
    public Request addRequest(Employee u, String purpose, double amount) {
        Request a = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = " insert into request(requester_id, purpose, amount) "+
            		" values(?, ?, ?) RETURNING request_id INTO ?";

            OraclePreparedStatement ps = (OraclePreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, u.getEmployee_id());
            ps.setString(2, purpose);
            ps.setDouble(3, amount);
            ps.registerReturnParameter(4, OracleTypes.NUMBER);

            int count = ps.executeUpdate();

            if (count > 0) {
                ResultSet rs = ps.getReturnResultSet();


                if (rs.next()) {
                    int newRequestId = rs.getInt(1);


                    a = getRequest(newRequestId);

                }
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return a;
    }


	//get request by requestid
	@Override
	public Request getRequest(int requestId) {
		
		
			Request r = null;
			
			try(Connection connect = ConnectionFactory.getInstance().getConnection();){
				String sql = "select * from request r " +
						" inner join state_type s " +
						" on r.state_id = s.STATE_ID " +
						" where r.request_id = ? ";
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setInt(1, requestId);
				ResultSet info = ps.executeQuery();
				//request_id, requester_id, resolver_id, note, purpose, state_id
				//opened, closed, amount, state_id, name;
				
				if(info.next()){
					r = new Request();
					r.setRequest_id(info.getInt(1));
					r.setRequester_id(info.getInt(2));
					r.setResolver_id(info.getInt(3));
					r.setNote(info.getString(4));
					r.setPurpose(info.getString(5));
					r.setState(new State_type(info.getInt(6),info.getString(11)));
					r.setOpened(info.getDate(7));
					r.setClosed(info.getDate(8));
					r.setAmount(info.getDouble(9));

				}
				
	
				return r;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return r;
		}
	

}
