package com.ers.pojos;

public class ReimbursementState {
	private int stateId;
	String stateName;
	
	public ReimbursementState() {
		
	}

	public ReimbursementState(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "ReimbursementState [stateId=" + stateId + ", stateName=" + stateName + "]";
	}
}
