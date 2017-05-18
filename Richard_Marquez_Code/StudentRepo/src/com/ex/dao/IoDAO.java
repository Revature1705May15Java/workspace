package com.ex.dao;

import java.io.*;
import java.util.ArrayList;
import com.ex.pojos.Student;

public class IoDAO implements DAO {

	final static String filename = "src/com/ex/dataSource/data.txt";
	
	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		// try w/ resources good for resources that need to be closed
		// new FileWriter takes true to append rather than rewrite
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write(id + ":" + fName + ":" + lName + ":" + email + "\n");
			return s;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Student updateStudent(Student updatedStudent) {
		Student replaced = null;
		ArrayList<Student> allStudents = getAllStudents();

		for (int i = 0; i < allStudents.size(); i++) {
			if (allStudents.get(i).getId() == updatedStudent.getId()) {
				allStudents.set(i, updatedStudent);
				replaced = updatedStudent;
				break;
			}
		}
		
		writeStudents(allStudents);
		
		return replaced;
	}

	@Override
	public boolean removeStudent(Student removedStudent) {
		boolean removed = false;
		ArrayList<Student> allStudents = getAllStudents();

		for (Student s : allStudents) {
			if (s.getId() == removedStudent.getId()) {
				allStudents.remove(s);
				removed = true;
				break;
			}
		}
		
		writeStudents(allStudents);
		
		return removed;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String currLine = null;
			
			while ((currLine = br.readLine()) != null) {
				String[] tokens = currLine.split(":");
				
				Student tmp = new Student();
				tmp.setId(Integer.parseInt(tokens[0]));
				tmp.setFirstName(tokens[1]);
				tmp.setLastName(tokens[2]);
				tmp.setEmail(tokens[3]);
				
				students.add(tmp);
			}
			
			return students;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public Student getStudentById(int id) {
		Student result = null;
		
		ArrayList<Student> allStudents = getAllStudents();
		
		for (Student s : allStudents) {
			if (s.getId() == id) {
				result = s;
				break;
			}
		}
		
		return result;
	}

	private void writeStudents(ArrayList<Student> students) {		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename));) {
			for (Student s : students) {
				bw.write(s.getId() + ":" + s.getFirstName() + ":" + s.getLastName() + ":" + s.getEmail() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
