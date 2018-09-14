package com.autism.AutismAppServer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent_user")
public class ParentUser {

	@Id
	@Column(name = "parent_user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parentUserId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "country")
	private String country;

	@Column(name = "mobile_no")
	private String mobileNumber;

	@Column(name = "child_relation")
	private String childRelation;

	@Column(name = "gender")
	private String gender;

	@Column(name = "status")
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

	@Override
	public String toString() {
		return "ParentUser [parentUserId=" + parentUserId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", occupation=" + occupation + ", country=" + country + ", mobileNumber="
				+ mobileNumber + ", childRelation=" + childRelation + ", gender=" + gender + ", status=" + status + "]";
	}

	

}
