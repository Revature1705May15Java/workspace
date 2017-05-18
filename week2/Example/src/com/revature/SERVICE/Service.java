package com.revature.SERVICE;

import java.util.Scanner;

import com.revature.DAO.DAO;

public class Service {
	
	DAO dao = new DAO();
	
	
	public String getStudentStatus(){
		
		System.out.println("Hey, whats your students status?");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int s = scan.nextInt();
		
		System.out.println("Your student is " + dao.getDepartment(s));
		
		return null;
		
	}

}
