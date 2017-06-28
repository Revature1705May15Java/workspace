package com.ers.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ers.dao.DAO;
import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public class Service {
	private static boolean isLoggedIn=false;
	private static DAO dao = new DaoImpl();
	private static String[] statenames;
	public static HashMap<Integer,String> reqnames=new HashMap<Integer,String>();
	public static HashMap<Integer,String> resnames=new HashMap<Integer,String>();
	
	public Service(){
		
	}
	private static void mapRequestersResolvers(){
		ArrayList<Employee> emps=new ArrayList<Employee>();
		emps=dao.getAllEmployees();
		for(Employee emp:emps){
			if(emp.getIsmanager()==0){
				String name=emp.getFirstname()+" "+emp.getLastname();
				Integer id=emp.getId();
				reqnames.put(id,name);
			}else{
				String name1=emp.getFirstname()+" "+emp.getLastname();
				Integer id1=emp.getId();
				resnames.put(id1,name1);
			}
		}
	}
	public static Employee loginUser(String email,String password){
		Employee temp=new Employee();
		temp=dao.getEmployee(email);
		if(temp!=null){
			String actualpw=temp.getPassword();
			if(actualpw.equals(password)){
				isLoggedIn=true;
				return temp;
			}else{
				return null;
			}
		}else{
			return null;
		}
		
	}
	public static boolean logoutUser(){
		isLoggedIn=false;
		return isLoggedIn;
	}
	public static Employee newEmployee(String email, String pw, String fn,String ln,int ismanager){
		dao.addEmployee(email, pw, fn, ln, ismanager);
		Employee temp =dao.getEmployee(email);
		return temp;
	}
	public static ArrayList<Employee> getAllEmployees(){
		ArrayList<Employee> emps=new ArrayList<Employee>();
		emps=dao.getAllEmployees();
		return emps;
	}
	public static void getStateNames(){
		statenames=dao.getStateNames();
	}
	public static ArrayList<Request> getRequests(Employee emp){
		ArrayList<Request> reqs=new ArrayList<Request>();
		reqs=dao.getEmployeeRequests(emp.getId());
		reqs=addRequestNames(reqs);
		return reqs;
	}
	public static void newRequest(double amount, String purpose,Employee emp){
		int empid=emp.getId();
		dao.addRequest(amount, purpose, empid);
	}
	public static ArrayList<Request> getAllRequests(){
		ArrayList<Request> reqs=new ArrayList<Request>();
		reqs=dao.getAllRequests();
		reqs=addRequestNames(reqs);
		return reqs;
	}
	public static ArrayList<Request> addRequestNames(ArrayList<Request> reqs){
		getStateNames();
		mapRequestersResolvers();
		for(Request req:reqs){
			req.setReqname(reqnames.get(req.getRequesterid()));
			if(req.getResolverid()>0){
				req.setResname(resnames.get(req.getResolverid()));
			}
			switch(req.getStateid()){
				case(1):
					req.setName(statenames[0]);
					break;
				case(2):
					req.setName(statenames[1]);
					break;
				case(3):
					req.setName(statenames[2]);
					break;
				default:
					req.setName("Status unknown.");
					break;
			}
		}
		return reqs;
	}
	public static void updateEmployee(String email, String pw, String fn, String ln, int empid){
		dao.updateEmployee(email, pw, fn, ln, empid);
	}
	public static void approveRequests(int[] requestIds,String[] approvenotes, int resolverid){
		
		dao.updateRequests(2, requestIds,approvenotes,resolverid);
	}
	public static void denyRequests(int[] requestIds,String[] denynotes, int resolverid){
		
		dao.updateRequests(3, requestIds,denynotes,resolverid);
	}
}