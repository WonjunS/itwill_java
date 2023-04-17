package com.example.project.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Member implements Serializable {
	
	public interface Entity {
		String TBL_NAME = "MEMBER";
		String COL_ID = "MEMBER_ID";
		String COL_NAME = "MEMBER_NAME";
		String COL_EMAIL = "EMAIL";
		String COL_PASSWORD = "PASSWORD";
		String COL_PHONE = "PHONE";
		String COL_GENDER = "GENDER";
		String COL_NATIONALITY = "NATIONALITY";
		String COL_CREATED_TIME = "CREATED_TIME";
		String COL_MODIFIED_TIME = "MODIFIED_TIME";
	}
	
	private int memberId;
	private String memberName;
	private String email;
	private String password;
	private String phone;
	private String gender;
	private String nationality;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	
	public Member(int memberId, String memberName, String email, String password, 
			String phone, String gender, String nationality) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.nationality = nationality;
	}
	
	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}