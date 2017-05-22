package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.IoDAO;
import com.rev.pojo.Student;
import com.rev.serialize.Serialize;

public class StudentService 
{
	DAO dao = new IoDAO();
	Serialize sz = new Serialize();
	
	public boolean addStudent(String fn, String ln,String email)
	{
		
		//used for checking unique email and getting id
		ArrayList <Student> stuList = dao.getAllStudents();
		Student currStu = null;
		
		//used for making student object and adding to list
		int id;
		Student newStu = null;
		
		
		//used to addStudent to empty list
		if(stuList.isEmpty())
		{
			id = 1;
			newStu = new Student (fn,ln,email,id);
			dao.addStudent(newStu);
			return true;
		}
		
		//goes through list to check for email
		for(int i = 0;i<stuList.size();i++)
		{
			currStu = stuList.get(i);
			
			//removes if unique email is the same
			if(email.equals(currStu.getEmail()))
			{
				return false;
			}
		}
		
		//adds student, assigns id by adding one to last entry's id
		currStu = stuList.get(stuList.size()-1);
		id = currStu.getId() + 1;
		
		newStu = new Student (fn,ln,email,id);
		dao.addStudent(newStu);
		return true;
		
		

	
	}
	
	public boolean RemoveStudent (String s)
	{
		//used to pass new array to remove
		ArrayList <Student> stuList = dao.getAllStudents();
		
		//used to find entry to remove
		Student currStu = null;
		boolean found = false;
		
		//goes through list
		for(int i = 0;i<stuList.size();i++)
		{
			currStu = stuList.get(i);
			
			//removes if unique email is the same
			if(s.equals(currStu.getEmail()))
			{
				stuList.remove(i);
				found = true;
			}
		}
		
		//only removes if entry is found
		if(found)
		{
			dao.removeStudent(stuList);
		}
			
			return found;
	}
	
	public Student updateStudent (String s,String u,int x)
	{
		//used to pass new array to update
		ArrayList <Student> stuList = dao.getAllStudents();
		
		//used to update
		Student currStu = null;
		boolean found = false;
		int index = -1;
		
		//goes through list
		for(int i = 0;i<stuList.size();i++)
		{
			currStu = stuList.get(i);
			
			//update if id is the same
			if(s.equals(currStu.getEmail()))
			{
				found = true;
				index = i;
				break;
			}
		}
		
		//only removes if entry is found
		if(found)
		{
			if(x == 1)
			{
				currStu.setFirstName(u);
				stuList.set(index, currStu);
				dao.updateStudent(stuList);
				
				return currStu;
			}
			
			if(x == 2)
			{
				currStu.setLastName(u);;
				stuList.set(index, currStu);
				dao.updateStudent(stuList);
				
				return currStu;
			}
			
		}

		
			return null;
			
			
	}
	
	public void getStudents ()
	{
		ArrayList <Student> stuList = dao.getAllStudents();
		
		for(int i = 0;i<stuList.size();i++)
		{
			System.out.println(stuList.get(i));
		}
	}

	public void serialize() 
	{
		String bytestream = "src/com/rev/serialize/bytestream.txt";
		ArrayList <Student> stuList = dao.getAllStudents();
		
		
		sz.writeObject(bytestream, stuList);
		
	}
	
	public boolean findByEmail (String s)
	{
		//used to pass new array to update
		ArrayList <Student> stuList = dao.getAllStudents();
		
		//used to update
		Student currStu = null;
		boolean found = false;
		int index = -1;
		
		//goes through list to find email
		for(int i = 0;i<stuList.size();i++)
		{
			currStu = stuList.get(i);
			
			if(s.equals(currStu.getEmail()))
			{
				found = true;
				System.out.println(currStu);
				break;
			}
		}
		
		return found;
	}
}
