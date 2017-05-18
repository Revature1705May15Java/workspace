package com.revature_wk1.service;

import com.revature_wk1.dao.ConcreteDAO;
import com.revature_wk1.dao.DAO;
import com.revature_wk1.pojos.Student;

public class StudentService 
{
	DAO dao = new ConcreteDAO();
	
	public Student addStudent(String fn, String ln, String em, int id)
	{
		return null;
	}
}
