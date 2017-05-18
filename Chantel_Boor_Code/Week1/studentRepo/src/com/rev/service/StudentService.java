package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.IoDAO;
import com.rev.pojo.Student;

public class StudentService 
{
	DAO dao = new IoDAO();
	
	public Student addStudent(String fn, String ln, String email){return null;}
	

	
	/*create student object taking in only 3 param
	 * -fn,ln,email
	 * service layer aka buisness logic layer handles the functionality
	 * of getting the most recently used ID and assigning the new student the next value
	 * -must also only accept unique email address*/
}
