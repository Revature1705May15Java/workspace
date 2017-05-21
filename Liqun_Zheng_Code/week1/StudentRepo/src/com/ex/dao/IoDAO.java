package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IoDAO implements DAO{
	 
	//data txt file path
	String filename = "src/com/ex/datasource/data.txt";

	//override addStudent method by adding a student object
	@Override
	public void addStudent(Student s) {
		Student result = null;
		
		//assign student object to local 
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){//True @param enables append capabilities
			
			//write to the file
			bw.write(""+id+":"+fName+":"+lName+":"+email+"\n");
//			result.setId(id);
//			result.setFirstName(fName);
//			result.setLastName(lName);
//			result.setEmail(email);
			bw.flush();
			
			//close BufferedWriter
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//return result;
	}

	//remove student by id
	@Override
	public Student removeStudent(int id) {
		Student result=null;
		try {
			//Create ArrayList of student
			ArrayList<Student> st = new ArrayList<Student>();
			
			//Create BufferedReader 
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine())!=null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				//add each line from file to ArrayList of students
				st.add(temp);
			}
			
			//check and remove student by id from ArrayList
			for(int i =0; i< st.size(); i++){
				if(st.get(i).getId() == id){
					result = st.get(i);
					st.remove(i);
				}
//				System.out.println("New table" + st.get(i).toString());
			}
			
			//create temporary variables of student
			int tempId;
			String fName, lname, email;
			
			//create a BufferedWriter
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			
			for(int i=0; i<st.size();i++)
			{
				tempId = st.get(i).getId();
				fName = st.get(i).getFirstName();
				lname = st.get(i).getLastName();
				email = st.get(i).getEmail();
				
				//write each student from ArrayList to txt file filename
				bw.write(""+tempId+":"+fName+":"+lname+":"+email +"\n");
			}
			br.close();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	//get all students from the data file
	@Override
	public ArrayList<Student> getAllStudents() throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Create Student 
		ArrayList<Student> students = new ArrayList<Student>();
		
			try {
				//create BufferedReader
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				
				//read line from file until it is empty
				while((line = br.readLine())!=null){
					//split each variables using : from file
					String[] curr = line.split(":");
					
					//creat a temporary student and assign each variables to it
					Student temp = new Student();
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFirstName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					
					//add each student to ArrayList
					students.add(temp);
					System.out.println(temp);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return students;
	}

	//get student by email address
	@Override
	public Student getStudentByEmail(String email) {
		try {
			//Create BufferedReader
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			//read file till it is empty
			while((line = br.readLine())!=null){
				//split each variables using : from file
				String[] curr = line.split(":");
				
				//create a temporary student assign each student to it to check for same email
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				//check if this student has same email
				if (temp.getEmail().equals(email)){
					System.out.println(temp);
					return temp;
				}
			}
			br.close();
			
			System.out.println("Didn't find that email");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	//update student information by enter student information
	@Override
	public Student updateStudent(Student updatedStudent) {
		try {
			
			//Create student ArrayList
			ArrayList<Student> st = new ArrayList<Student>();
			
			//Create BUfferedReader
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			//read file till it is empty
			while((line = br.readLine())!=null){
				//split each variables using : from file
				String[] curr = line.split(":");
				
				//create temporary student and assign each variable from reader to it
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				//add this temporary student to student ArrayList
				st.add(temp);
			}
			
			//check student id matches then update rest of information to it.
			for(int i =0; i< st.size(); i++){
				if(st.get(i).getId() == updatedStudent.getId()){
					st.get(i).setFirstName(updatedStudent.getFirstName());
					st.get(i).setLastName(updatedStudent.getLastName());
					st.get(i).setEmail(updatedStudent.getEmail());
				}
				System.out.println("New table" + st.get(i).toString());
			}
			
			int id;
			String fName, lname, email;
			
			//Create BufferedWriter
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			//rewrite student ArrayList to data file
			for(int i=0; i<st.size();i++)
			{
				id = st.get(i).getId();
				fName = st.get(i).getFirstName();
				lname = st.get(i).getLastName();
				email = st.get(i).getEmail();
			
				bw.write(""+id+":"+fName+":"+lname+":"+email +"\n");
			}
			br.close();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedStudent;
	}
}
