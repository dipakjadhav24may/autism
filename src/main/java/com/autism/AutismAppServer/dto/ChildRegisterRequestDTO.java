package com.autism.AutismAppServer.dto;

public class ChildRegisterRequestDTO {

	private int childUserId;

	private String firstName;

	private String age;

	private String gender;

	private String note;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getChildUserId() {
		return childUserId;
	}

	public void setChildUserId(int childUserId) {
		this.childUserId = childUserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
