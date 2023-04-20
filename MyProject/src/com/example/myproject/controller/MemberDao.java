package com.example.myproject.controller;

import com.example.myproject.model.Member;

public interface MemberDao {
	
	Member getLoginInfo(String email, String password);
	
	boolean validateEmail(String email);
	
	boolean validateNickname(String nickname);
	
	int createMember(Member member);
	
	int updateNickname(Member member);
	
	int updatePassword(Member member);
	
	int deleteMember(Member member);

}
