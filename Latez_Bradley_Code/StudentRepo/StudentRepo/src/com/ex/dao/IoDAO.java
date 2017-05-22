package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Student;

public class IoDAO implements DAO {
	
	String filename = "src/com/ex/datasource/data.txt";

	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFristName();
		String lname = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){//True @param enables append capabilities
			bw.write(""+id+":"+fName+":"+lname+":"+email +"\n");
			
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
	public boolean removeStudent(String email) {
        List<Student> studentList = getAllStudents();
        boolean removed = false;    
        for(Student s: studentList){
                if(email.equals(s.getEmail())){
                    studentList.remove(s);
                    removed = true;
                    break;
                }
            }
            
        if(removed){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename));){
                for(Student s: studentList){
                    bw.write("" + s.getId() + ":" + s.getFristName() + ":" + s.getLastName() + ":" + s.getEmail() + "\n");
                }
            }catch (IOException e) {
                e.printStackTrace();
                
            }
        }
        
            return removed;
            
        
        
    }


	@Override
	public ArrayList<Student> getAllStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<Student>();
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				int count=0;
				
				while((line = br.readLine())!=null){
					String[] curr = line.split(":");
					
					Student temp = new Student();
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFristName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					
					students.add(temp);
					System.out.println(temp);
					System.out.println(line);
					
					//count++;
					//System.out.println(count);
				}
				
				
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return students;
	}


	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student s=null;
		ArrayList <Student> a = getAllStudents();
		for(int i=0;i<a.size();i++){
			if(id == a.get(i).getId())
				s = a.get(i);
			else
				System.out.println(id+" !="+a.get(i).getEmail());
		}
		return s;
		
	
	}
	@Override
	public Student getStudentByEmail(String e){
		Student s=null;
		ArrayList <Student> a = getAllStudents();
		for(int i=0;i<a.size();i++){
			if(e.equals(a.get(i).getEmail()))
				s = a.get(i);
			else
				System.out.println(e+" !="+a.get(i).getEmail());
		}	
		return s;
	}

	@Override
	public Student updateStudent(String e, Student updatedStudent) {
		// TODO Auto-generated method stub
		removeStudent(e);
		addStudent(updatedStudent);
		return null;
	}
	@Override
	public boolean checkEmail(String e) {
		// TODO Auto-generated method stub
		Student s=null;
		ArrayList <Student> a = getAllStudents();
		for(int i=0;i<a.size();i++){
			if(e.equals(a.get(i).getEmail()))
				System.out.println();
				return true;
	
		}	
		return false;
	}



	




	

}
