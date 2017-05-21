package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IoDAO implements DAO {
	
	static String filename = "src/com/ex/datasource/data.txt"; // data source file

	/*
	 * Given a Student object we will use this method to 
	 * add the data contained in the Student object to the
	 * data.txt file.
	 */
	@Override
	public Student addStudent(Student s){
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return s;
	}

	/*
	 * Given the id from the user this method will check if the 
	 * given id is present within the data.txt file, if so it will
	 * then proceed to remove that student form the data.txt file.
	 */
	@Override
	public void removeStudent(int id) {
		ArrayList<Student> rStudents = new ArrayList<Student>();
		
		try{
			BufferedReader rmReader = new BufferedReader(new FileReader(filename));
			
			String line = null;
			
			while((line = rmReader.readLine()) != null){
				Student rStudent = new Student();
				String[] nLine = line.split(":");
				
				rStudent.setId(Integer.parseInt(nLine[0]));
				rStudent.setFirstName(nLine[1]);
				rStudent.setLastName(nLine[2]);
				rStudent.setEmail(nLine[3]);
				
				rStudents.add(rStudent);
				
				if(rStudent.getId() == id)
				{
					rStudents.remove(rStudent);
				}
			}
			
			BufferedWriter rmBuffer = new BufferedWriter(new FileWriter(filename));
			int sId = 0;
			String fName, lName, email;
			for(int i = 0; i < rStudents.size(); i++){
				sId = rStudents.get(i).getId();
				fName = rStudents.get(i).getFirstName();
				lName = rStudents.get(i).getLastName();
				email = rStudents.get(i).getEmail();
				
				rmBuffer.write("" + sId + ":" + fName + ":" + lName + ":" + email + "\n");
			}
			
			rmReader.close();
			rmBuffer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * This method will show a visual representation of the data.txt file,
	 * which will show the in the console.
	 */
	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			String line = null; //current line place holder
			
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				students.add(temp);
				System.out.println(temp.toString());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}

	/*
	 * Given the student ID this method will print out the information for 
	 * that student as well as return that student as a Student object.
	 */
	@Override
	public Student getStudentById(int id) {
		Student temp = new Student();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			String line = null; //current line place holder
			
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				
				
				if(Integer.parseInt(curr[0])==id){
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFirstName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					System.out.println(temp.toString());
				}
				
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	/*
	 * This method accepts a Student object that will contain
	 * the ID of the student you will want to replace. If the 
	 * ID matches then the given Student object will replace the 
	 * old data in the data.txt
	 */
	@Override
    public void updateStudent(Student updatedStudent) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
            ArrayList<Student> st = new ArrayList<Student>();
            String line = null; //current line place holder
            
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
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/*
	 * This method is used to check if the given int ID is already in
	 * use. If that is the case it will return a new unique int ID
	 * the display it to the user.
	 */
	@Override
	public int checkId(int id) {
		int uniqueId = id;
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			String line = null; //current line place holder
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				if(Integer.parseInt(curr[0])==id){
					uniqueId = id + 1;
					System.out.println("This ID is already in use new user ID is: " + uniqueId);
				}
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uniqueId;
	}

}
