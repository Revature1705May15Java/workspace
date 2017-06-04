package com.rev.pojo;

import java.util.ArrayList;

public class User {
	int id, isBoss;
	String fn, ln, pw, em;
	ArrayList<Request> userRequest;
	
	public User(int id, int isBoss, String fn, String ln, String pw, String em, ArrayList<Request> userRequest) {
		super();
		this.id = id;
		this.isBoss = isBoss;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.em = em;
		this.userRequest = userRequest;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIsBoss() {
		return isBoss;
	}
	public void setIsBoss(int isBoss) {
		this.isBoss = isBoss;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	public ArrayList<Request> getUserRequest() {
		return userRequest;
	}
	public void setUserRequest(ArrayList<Request> userRequest) {
		this.userRequest = userRequest;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", isBoss=" + isBoss + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", em=" + em
				+ ", userRequest=" + userRequest + "]";
	}
	
}
