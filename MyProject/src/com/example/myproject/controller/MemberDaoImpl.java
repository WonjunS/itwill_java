package com.example.myproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.myproject.model.Member;

import oracle.jdbc.OracleDriver;

import static com.example.myproject.ojdbc.OracleConnect.*;
import static com.example.myproject.model.Member.Entity.*;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new MemberDaoImpl();
		}
		
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	private void closeResources(Connection conn, PreparedStatement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	private static final String SQL_SELECT_MEMBER_INFO = 
			"select *"
			+ " from " + TBL_NAME
			+ " where " + COL_EMAIL + " = ?"
			+ " and " + COL_PASSWORD + " = ?";

	@Override
	public Member getLoginInfo(String email, String password) {
		Member findMember = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_MEMBER_INFO);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				int memberId = rs.getInt(COL_ID);
				String memberName = rs.getString(COL_NAME);
				email = rs.getString(COL_EMAIL);
				password = rs.getString(COL_PASSWORD);
				
				findMember = new Member(memberId, memberName, email, password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return findMember;
	}
	
	private static final String SQL_CREATE = 
			"insert into " + TBL_NAME + 
			" (" + COL_NAME + ", " + COL_EMAIL + ", " + COL_PASSWORD + ") " + 
			"values(?, ?, ?)";

	@Override
	public int createMember(Member member) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_CREATE);
			stmt.setString(1, member.getMemberName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getPassword());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	private static final String SQL_SELECT_EMAIL = 
			"select *"
			+ " from " + TBL_NAME
			+ " where " + COL_EMAIL + " = ?";

	@Override
	public boolean validateEmail(String email) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_EMAIL);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
