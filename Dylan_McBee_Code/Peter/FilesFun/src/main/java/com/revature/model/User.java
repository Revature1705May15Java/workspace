package com.revature.model;

import java.util.Arrays;

import javax.persistence.*;


@Entity
@Table(name = "USER_T")
public class User {
	
	@Id
	@Column(name= "U_ID")
	private int id;
	
	@Column(name= "U_USERNAME")
	private String userName;
	
	@Column(name= "U_PASSWORD")
	private String password;
	
	@Column(name= "U_IMAGE")
	private byte[] image;
	
	@Column(name = "U_S3_IMAGE")
	private String s3Image;
	
	public User(){
		userName="";
		password="";
		image = new byte[1];
		s3Image = "";
	}
	
	public User(String userName){
		this();
		this.userName = userName;
	}
	public User(String userName, String password){
		this();
		this.userName = userName;
		this.password = password;
	}

	public User(int id, String userName, String password, byte[] image, String s3Image) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.image = image;
		this.s3Image = s3Image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getS3Image() {
		return s3Image;
	}

	public void setS3Image(String s3Image) {
		this.s3Image = s3Image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", image="
				+ Arrays.toString(image) + ", s3Image=" + s3Image + "]";
	}
	
	
}
