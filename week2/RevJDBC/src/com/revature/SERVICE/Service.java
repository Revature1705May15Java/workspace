package com.revature.SERVICE;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.DAO.DAO;

public class Service {

	
	DAO dao = new DAO();
	
	
	public String getStudentStatus(){
		
		System.out.println("Hey, whats your students status?");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int s = scan.nextInt();
		
		try {
			System.out.println("Your student is " + dao.getStatus(s));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
