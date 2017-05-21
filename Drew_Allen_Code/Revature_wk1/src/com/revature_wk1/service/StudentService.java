package com.revature_wk1.service;

import java.util.ArrayList;

import com.revature_wk1.dao.ConcreteDAO;
import com.revature_wk1.dao.DAO;
import com.revature_wk1.pojos.Student;

public class StudentService extends ConcreteDAO
{
	DAO dao = new ConcreteDAO();

	@Override
	public Student addStudent(Student s) 
	{
		dao.addStudent(s);
		return s;
	}

	@Override
	public void removeStudent(int id) 
	{
		dao.removeStudent(id);
	}

	@Override
	public ArrayList<Student> getAllStudents() 
	{
		return dao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) 
	{
		return dao.getStudentById(id);
	}

	@Override
	public void updateStudent(Student updatedStudent) 
	{
		dao.updateStudent(updatedStudent);
	}
	
	
}
