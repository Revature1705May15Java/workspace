package com.revature.service;

import com.revature.dao.ConcreteDAO;
import com.revature.dao.DAO;
import com.revature.pojos.Student;

public class StudentService 
{
	DAO dao = new ConcreteDAO();
	
	public Student addStudent(String fn, String ln, String em, int id)
	{
		return null;
	}
}
