package com.autism.AutismAppServer.dto;

public class ParentRegisterRequestDTO {

	private int parentUserId;

	private String firstName;

	private String lastName;

	private String email;

	private String occupation;

	private String country;

	private String mobileNumber;

	private String childRelation;

	private String gender;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getChildRelation() {
		return childRelation;
	}

	public void setChildRelation(String childRelation) {
		this.childRelation = childRelation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
