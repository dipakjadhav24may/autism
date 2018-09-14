package com.autism.AutismAppServer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "child_user")
public class ChildUser {

	@Id
	@Column(name = "child_user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int childUserId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "age")
	private String age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "note")
	private String note;

	@Column(name = "status")
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

	@Override
	public String toString() {
		return "ChildUser [childUserId=" + childUserId + ", firstName=" + firstName + ", age=" + age + ", gender="
				+ gender + ", note=" + note + ", status=" + status + "]";
	}

}
