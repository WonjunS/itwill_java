package com.example.myproject.controller;

import com.example.myproject.model.Member;

public interface MemberDao {
	
	Member getLoginInfo(String email, String password);
	
	boolean validateEmail(String email);
	
	int createMember(Member member);

}
