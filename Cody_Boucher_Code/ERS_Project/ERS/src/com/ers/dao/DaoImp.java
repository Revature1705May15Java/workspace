package com.ers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.util.ConnectionFactory;

public class DaoImp implements DAO{

	@Override
	public Employee getEmployee(String username) {
		Employee emp = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from employee where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				emp.setUsername(info.getString(1));
				emp.setPassword(info.getString(2));
				emp.setId(info.getInt(3));
				emp.setFirstName(info.getString(4));
				emp.setLastName(info.getString(5));
				if(info.getInt(6) == 0) {
					emp.setManager(false);
				}
				else {
					emp.setManager(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from employee where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				emp.setUsername(info.getString(1));
				emp.setPassword(info.getString(2));
				emp.setId(info.getInt(3));
				emp.setFirstName(info.getString(4));
				emp.setLastName(info.getString(5));
				if(info.getInt(6) == 0) {
					emp.setManager(false);
				}
				else {
					emp.setManager(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee addEmployee(String username, String password, String firstName, String lastName, boolean isManager) {
		Employee emp = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into employee(username, password, firstname, lastname, ismanager) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			if(isManager == true) {
				ps.setInt(5, 1);
			}
			else {
				ps.setInt(5, 0);
			}
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Reimbursement requestReimbursement(int requesterId, double amount, String purpose) {
		Reimbursement rem = new Reimbursement();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into requests(amount, purpose, requesterid) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, purpose);
			ps.setInt(3, requesterId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rem;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		//Employee updateEmp = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update employee set username = ?, password = ?, firstname = ?, lastname = ? where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println("In DAOIMP");
			ps.setString(1, emp.getUsername());
			System.out.println(emp.getUsername());
			ps.setString(2, emp.getPassword());
			System.out.println(emp.getPassword());
			
			ps.setString(3, emp.getFirstName());
			System.out.println(emp.getFirstName());
			ps.setString(4, emp.getLastName());
			System.out.println(emp.getLastName());
			ps.setInt(5, emp.getId());
			System.out.println(emp.getId());
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public ArrayList<Reimbursement> getEmployeeReimbursement(int id) {
		ArrayList<Reimbursement> employeeReimbursements = new ArrayList<Reimbursement>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql ="select * from requests where requesterid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setStateId(info.getInt(1));
				temp.setDateRequested(info.getDate(2));
				temp.setDateResolved(info.getDate(3));
				temp.setAmount(info.getDouble(4));
				temp.setPurpose(info.getString(5));
				temp.setRequestId(info.getInt(6));
				temp.setRequesterId(info.getInt(7));
				temp.setResolverId(info.getInt(8));
				temp.setNotes(info.getString(9));
				employeeReimbursements.add(temp);
			}
			return employeeReimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursements() {
		ArrayList<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from requests";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setStateId(info.getInt(1));
				temp.setDateRequested(info.getDate(2));
				temp.setDateResolved(info.getDate(3));
				temp.setAmount(info.getDouble(4));
				temp.setPurpose(info.getString(5));
				temp.setRequestId(info.getInt(6));
				temp.setRequesterId(info.getInt(7));
				temp.setResolverId(info.getInt(8));
				temp.setNotes(info.getString(9));
				allReimbursements.add(temp);
			}
			return allReimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reim, String note, int state) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update requests set stateid = ?, dateResolved = ?, resolverid = ?, notes = ? where requestid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, reim.getStateId());
			System.out.println("dao reim state" + reim.getStateId());
			
			ps.setDate(2, reim.getDateResolved());
			
			ps.setInt(3, reim.getResolverId());
			System.out.println("dao reim resolver" + reim.getResolverId());
			
			ps.setString(4, reim.getNotes());
			System.out.println("dao reim note" + reim.getNotes());
			
			ps.setInt(5, reim.getRequestId());
			System.out.println("dao reim requestId" + reim.getRequestId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reim;
	}

	@Override
	public Reimbursement getReimbursement(int id) {
		Reimbursement reim = new Reimbursement();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from requests where requestid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				reim.setStateId(info.getInt(1));
				reim.setDateRequested(info.getDate(2));
				reim.setDateResolved(info.getDate(3));
				reim.setAmount(info.getDouble(4));
				reim.setPurpose(info.getString(5));
				reim.setRequestId(info.getInt(6));
				reim.setRequesterId(info.getInt(7));
				reim.setResolverId(info.getInt(8));
				reim.setNotes(info.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;
	}
}