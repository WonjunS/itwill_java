package com.example.myproject.model;

public class Member {
	
	public interface Entity {
		String TBL_NAME = "MEMBER";
		String COL_ID = "MEMBER_ID";
		String COL_NAME = "MEMBER_NAME";
		String COL_EMAIL = "EMAIL";
		String COL_PASSWORD = "PASSWORD";
	}
	
	private int memberId;
	private String memberName;
	private String email;
	private String password;
	
	public Member(int memberId, String memberName, String email, String password) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
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

}
