package com.ers.test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.ers.dao.DAO;
import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;;;

public class test {
	
	static DAO d = new DaoImpl();
	static Service service = new Service();
	static Employee ce = new Employee();
	static ArrayList <Request> r = new ArrayList <Request>();
	
	static Scanner scan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ce = service.login("225Yose", "yose");
		//service.getEmployee("225yose");
		//System.out.println(ce.getFirstname());
		//d.addEmployee("testUN", "pw", "John", "Doe", 0);
		//ce = d.getEmployee("225Yose");
		//System.out.println(ce.getFirstname());
		//d.request(500, "R&R", 142);
		//d.alterRequest(2, "You don't got it dude", 0,140);
		//System.out.println(d.viewEmployees());
		r= (d.getRequestsById(142));
		System.out.println(r);
		//r =d.viewOpenRequestsById(142);
		//r = d.viewClosedRequests(142);
		//System.out.println(r);
		String uname = "test@un";
		String pw = "pw";
		String fn ="Jane";
		String ln ="Dane";
		int id = 142;
		
		//d.updateEmployee(uname, pw, fn, ln, id);
		
		
	}

}