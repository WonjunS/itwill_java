package edu.java.jdbc02;

import static edu.java.jdbc.model.Blog.Entity.*;
import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain02 {
	
	public static void main(String[] args) {
		
		// DB 테이블에 insert 하기:
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 오라클 드라이버를 등록
			DriverManager.registerDriver(new OracleDriver());
			
			// DB에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// SQL 문장(Statement)을 준비
			String sql = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", 
					TBL_NAME, COL_TITLE, COL_CONTENT, COL_AUTHOR);
			System.out.println(sql);
			
			// SQL 문장을 실행할 수 있는 Statement 타입 객체 생성
			stmt = conn.prepareStatement(sql);
			
			// 제목, 내용 입력
			System.out.print("제목>> ");
			String title = sc.nextLine();
			System.out.print("내용>> ");
			String content = sc.nextLine();
			
			// SQL 문장에서 ? 부분을 채움
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, "서원준");
			
			// SQL 문장을 실행
			int result = stmt.executeUpdate();
			System.out.println(result + "개 행이 삽입됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
