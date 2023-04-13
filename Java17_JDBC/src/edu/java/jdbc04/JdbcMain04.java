package edu.java.jdbc04;

import static edu.java.jdbc.model.Blog.Entity.*;
import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain04 {
	
	public static void main(String[] args) {
		// 과제 JDBC delete:
		// delete from BLOGS where id = ?
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// Oracle JDBC 드라이버 등록
			DriverManager.registerDriver(new OracleDriver());
			
			// 오라클 DB에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// SQL 문 작성
			String sql = String.format("delete from %s where ID = ?", TBL_NAME);
			System.out.println(sql);
			
			stmt = conn.prepareStatement(sql);
			
			// ? 부분에 입력받은 id 값 적용
			System.out.print("삭제할 아이디 입력>>> ");
			int id = Integer.parseInt(sc.nextLine());
			stmt.setInt(1, id);
			
			// SQL 문장을 DB에서 실행
			int result = stmt.executeUpdate();
			System.out.println(result + "개의 행 삭제");
			
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
