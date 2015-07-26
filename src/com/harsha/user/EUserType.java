package com.harsha.user;

public enum EUserType {
	NORMAL(0), 
	EMPLOYEE(1), 
	AFFLIATED(2), 
	PREFERED(3);
	
	@SuppressWarnings("unused")
	private final int userType;
	
	private EUserType(int i) {
		this.userType = i;
	}
};