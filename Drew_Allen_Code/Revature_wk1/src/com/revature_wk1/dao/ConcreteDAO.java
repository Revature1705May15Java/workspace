package com.revature_wk1.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.revature_wk1.pojos.Student;

public class ConcreteDAO implements DAO
{
	static String filename = "src/com/revature/datasrc/Datr.txt";

	/*
	 * addStudent (Student s)
	 * This method reads and writes to a data text file to add a
	 * Student object to the data file
	 * 
	 * Takes in a Student object
	 * Returns a Student object
	 * Adds the Student object to the data text file
	 * 
	 * Created by Drew Allen
	 */
	
	@Override
	public Student addStudent(Student s) 
	{
		int id = s.getId();
		String fName = s.getFname();
		String lName = s.getLname();
		String email = s.getEmail();
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(filename, true));)
		{
			buffer.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
			return s;
		} catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * removeStudent(int id)
	 * This method will read from a existing file containing information of Student objects
	 * that will allow the user to remove a Student from their student ID value.
	 * 
	 * Takes in a int value for the id
	 * Returns nothing
	 * Updates the existing file of Students from the ArrayList of Student objects and return
	 * the file where the selected Student is removed
	 * 
	 * Created by Drew Allen
	 */
	
	@Override
	public void removeStudent(int id) 
	{
		ArrayList<Student> rStudents = new ArrayList<Student>();
		
		try
		{
			BufferedReader rmReader = new BufferedReader(new FileReader(filename));
			
			String line = null;
			
			while((line = rmReader.readLine()) != null)
			{
				Student rStudent = new Student();
				String[] nLine = line.split(":");
				
				rStudent.setId(Integer.parseInt(nLine[0]));
				rStudent.setFname(nLine[1]);
				rStudent.setLname(nLine[2]);
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
			for(int i = 0; i < rStudents.size(); i++)
			{
				sId = rStudents.get(i).getId();
				fName = rStudents.get(i).getFname();
				lName = rStudents.get(i).getLname();
				email = rStudents.get(i).getEmail();
				
				rmBuffer.write("" + sId + ":" + fName + ":" + lName + ":" + email + "\n");
			}
			
			rmReader.close();
			rmBuffer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	/*
	 * getAllStudents
	 * This method reads from a data text file that will
	 * display the information of all the Student objects
	 * inside the file back to the user
	 * 
	 * Takes and returns nothing
	 * Prints out the Student objects in a specific format
	 * 
	 * Created by Drew Allen
	 */
	
	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> gStudents = new ArrayList<Student>();
		
		try
		{
			BufferedReader bufferR = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = bufferR.readLine()) != null)
			{
				String[] str = line.split(":");
				Student s2 = new Student();
				s2.setId(Integer.parseInt(str[0]));
				s2.setFname(str[2]);
				s2.setLname(str[3]);
				s2.setEmail(str[1]);
				
				gStudents.add(s2);
				System.out.println(s2);
			}
			
			bufferR.close();
		}
		catch (FileNotFoundException e)
		{
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return gStudents;
	}

	/*
	 * getStudentById (int id)
	 * This method reads from a data text file to search for
	 * a specific Student object by their unique ID
	 * 
	 * Takes in a integer
	 * Returns a Student object
	 * Displays one Student object from the data file
	 * 
	 * Created by Arthur Faugue
	 */
	
	@Override
	public Student getStudentById(int id) 
	{
		Student temp = new Student();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			String line = null; //current line place holder
			
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				
				if(Integer.parseInt(curr[0])==id)
				{
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFname(curr[1]);
					temp.setLname(curr[2]);
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
	 * updateStudent (Student updatedStudent)
	 * This method reads and writes to a data text file to update the
	 * content of a specific Student object
	 * 
	 * Takes in a Student object
	 * Returns nothing
	 * Updates the existing Student object with new data from the user
	 * 
	 * Created by Liqun(Lee) Zheng
	 */

	@Override
    public void updateStudent(Student updatedStudent) 
	{
        try(BufferedReader br = new BufferedReader(new FileReader(filename));) 
        {
            ArrayList<Student> st = new ArrayList<Student>();
            String line = null; //current line place holder
            
            while((line = br.readLine())!=null){
                String[] curr = line.split(":");
                
                Student temp = new Student();
                temp.setId(Integer.parseInt(curr[0]));
                temp.setFname(curr[1]);
                temp.setLname(curr[2]);
                temp.setEmail(curr[3]);
                st.add(temp);
            }
            
            for(int i =0; i< st.size(); i++)
            {
                if(st.get(i).getId() == updatedStudent.getId())
                {
                    st.get(i).setFname(updatedStudent.getFname());
                    st.get(i).setLname(updatedStudent.getLname());
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
                fName = st.get(i).getFname();
                lname = st.get(i).getLname();
                email = st.get(i).getEmail();
            
                bw.write(""+id+":"+fName+":"+lname+":"+email +"\n");
            }
            bw.flush();
            bw.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

}
