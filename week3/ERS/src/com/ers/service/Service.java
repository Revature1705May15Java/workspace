package com.ers.service;

import com.ers.dao.DAO;
import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;

public class Service {
	private static boolean isLoggedIn=false;
	private static DAO dao = new DaoImpl();
	public static String[] statenames;
	
	public Service(){
		
	}
	public static Employee loginUser(String email,String password){
		Employee temp=new Employee();
		temp=dao.getEmployee(email);
		String actualpw=temp.getPassword();
		if(temp!=null&&actualpw.equals(password)){
			isLoggedIn=true;
			return temp;
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
	public static void getStateNames(){
		statenames=dao.getStateNames();
	}
	
	

}
