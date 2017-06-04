package com.reim.pojos;

public class State_type {
	int state_id;
	String name;
	
	public State_type(){}
	public State_type(int state_id, String name) {
		super();
		this.state_id = state_id;
		this.name = name;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "State_type [state_id=" + state_id + ", name=" + name + "]\n";
	}
	
	
}
