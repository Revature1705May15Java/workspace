package com.ex.beans;

public class Note {
	private String note;
	
	public void setNote(String note){
		this.note = note;
	}
	
	public void getNote(){
		System.out.println("Note: " + note);
	}
}
