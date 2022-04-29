package com.javatipsandinterview.basic.dto;

public class UserDTO {

	private String firstName;
	private String LastName;
	private String rollNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", LastName=" + LastName + ", rollNo=" + rollNo + "]";
	}

}
