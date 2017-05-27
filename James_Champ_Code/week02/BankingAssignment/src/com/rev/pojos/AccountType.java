package com.rev.pojos;

public class AccountType {
	public static final int CHECKING = 1;
	public static final int SAVINGS = 2;
	public static final int CREDIT = 3;
	
	private int typeId;
	private String name;
	
	// TODO: Test with incorrect type
	public AccountType(int type) {
		typeId = type;
		
		switch(typeId) {
			case CHECKING:
				name = "Checking";
				break;
			case SAVINGS:
				name = "Savings";
				break;
			case CREDIT:
				name = "Credit";
				break;
		}
	}
	
	public String getName() {
		return name;
	}
}
