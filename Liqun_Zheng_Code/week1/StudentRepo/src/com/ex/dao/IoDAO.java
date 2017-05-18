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

	String filename = "src/com/ex/datasource/data.txt";

	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFirstName();
		String lname = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){//True @param enables append capabilities
			bw.write(""+id+":"+fName+":"+lname+":"+email+"\n");
			bw.flush();
			bw.close();
			return s;
		}
		catch(IOException e){
			e.printStackTrace();
		return null;
		}
		// TODO Auto-generated method stub
		//return false;
	}

	@Override
	public void removeStudent(Student s) {
		try {
			ArrayList<Student> st = new ArrayList<Student>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine())!=null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				st.add(temp);
			}
			
			for(int i =0; i< st.size(); i++){
				if(st.get(i).getId() == s.getId()){
					st.remove(i);
				}
				System.out.println("New table" + st.get(i).toString());
			}
			
			int id;
			String fName, lname, email;
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
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
	}

	@Override
	public ArrayList<Student> getAllStudents() throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<Student>();
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				
				while((line = br.readLine())!=null){
					String[] curr = line.split(":");
					
					Student temp = new Student();
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFirstName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					
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

	@Override
	public Student getStudentById(int id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine())!=null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				if (temp.getId() == id){
					System.out.println(temp);
					return temp;
				}
			}
			br.close();
			
			System.out.println("Didn't find it");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public void updateStudent(Student updatedStudent) {
		try {
			ArrayList<Student> st = new ArrayList<Student>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine())!=null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				st.add(temp);
			}
			
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
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
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
	}

}
