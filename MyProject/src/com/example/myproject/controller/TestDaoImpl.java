package com.example.myproject.controller;

import static com.example.myproject.ojdbc.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class TestDaoImpl {
	
	private TestDaoImpl() {}
	
	private static TestDaoImpl instance = null;
	
	public static TestDaoImpl getInstance() {
		if(instance == null) {
			instance = new TestDaoImpl();
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		TestDaoImpl dao = TestDaoImpl.getInstance();
		
		dao.select();
	}
	
	public static void select() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from emp";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				
				System.out.println(empno + " " + ename + " " + job);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
