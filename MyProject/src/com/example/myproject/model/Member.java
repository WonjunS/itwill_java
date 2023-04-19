package com.example.myproject.model;

import java.time.LocalDateTime;

public class Member {
	
	public interface Entity {
		String TBL_NAME = "MEMBER";
		String COL_ID = "MEMBER_ID";
		String COL_NAME = "MEMBER_NAME";
		String COL_EMAIL = "EMAIL";
		String COL_PASSWORD = "PASSWORD";
		String COL_NICKNAME = "NICKNAME";
		String COL_CREATED_TIME = "CREATED_TIME";
		String COL_MODIFIED_TIME = "MODIFIED_TIME";
	}
	
	private int memberId;
	private String memberName;
	private String email;
	private String password;
	private String nickname;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	
	public Member(int memberId, String memberName, String email, String password, String nickname) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
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

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
