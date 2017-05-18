package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	DAO dao = new IoDAO();
	
	public Student addStudent(String fn,String ln, String email){return null;}
/*	Create student object taking in only 3 params:
	-fn,ln,email
	Service layer handles logic, gives student next available is, only accept unique email address
	*/
	
	
}
