package com.rev.serialization;

import java.io.Serializable;


public class Student implements Serializable,
								Comparable<Student> {
	/**
	 * Version number of this class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This student's first name.
	 */
	private String firstName;
	/**
	 * This student's last name.
	 */
	private String lastName;
	/**
	 * This student's email address.
	 */
	private String email;
	/**
	 * This student's unique ID number.
	 */
	private int id;
	
	/**
	 * Creates a new student object, but does not initialize
	 * any of the instance variables.
	 */
	public Student() {
		super();
	}
	
	/**
	 * Creates a new Student object and initializes its member variables with the 
	 * given data.
	 * 
	 * @param id		The student's ID number.
	 * @param firstName	The student's first name.
	 * @param lastName	The student's last name.
	 * @param email 	The student's email address.
	 */
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}

	/**
	 * Returns this student's first name.
	 * 
	 * @return	This student's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Changes this student's first name to the given String.
	 * 
	 * @param firstName	This student's new first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns this student's last name.
	 * 
	 * @return	This student's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Changes this student's last name to the given string.
	 * 
	 * @param lastName	This student's new last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns this student's email address.
	 * 
	 * @return	A String representation of this student's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets this student's email to the given email address.
	 * 
	 * @param email	This student's new email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns this student's ID number.
	 * 
	 * @return	This student's ID number.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Changes this student's ID number to the given number.
	 * 
	 * @param id	This student's new ID number.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Makes and returns a copy of this Student object.
	 * 
	 * @return	A copy of this Student.
	 */
	public Student makeCopy() {
		Student result = null;
		
		// TODO: Test this with a null Student object
		if(this != null) {
			result = new Student(id, firstName, lastName, email);
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return id + "\t" + lastName + ", " + firstName + "\t" + email;
	}

	@Override
	public int compareTo(Student stu) {
		if(id > stu.getId()) {
			return 1;
		}
		else if(id < stu.getId()) {
			return -1;
		}

		return 0;
	}
}
