package edu.java.jdbc03;

import static edu.java.jdbc.model.Blog.Entity.*;
import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain03 {
	
	public static void main(String[] args) {
		
		// JDBC update: 
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// Oracle JDBC 드라이버를 등록
			DriverManager.registerDriver(new OracleDriver());
			
			// 오라클 DB에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// Statement 준비
			String sql = String.format("update %s set %s = ?, %s = ?, %s = sysdate where %s = ?", 
					TBL_NAME, COL_TITLE, COL_CONTENT, COL_MODIFIED_TIME, COL_ID);
			System.out.println(sql);
			
			stmt = conn.prepareStatement(sql);
			
			// SQL 문장의 ? 부분을 채우기 위해서 id, 업데이트 할 제목/내용을 입력받음
			System.out.print("수정할 글 번호>> ");
			Integer id = Integer.parseInt(sc.nextLine());
			System.out.print("제목 업데이트>> ");
			String title = sc.nextLine();
			System.out.print("내용 업데이트>> ");
			String content = sc.nextLine();
			
			// SQL 문장의 ? 부분을 채움
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, id);
			
			// SQL 문장을 DB 서버에서 실행
			int result = stmt.executeUpdate();
			System.out.println(result + "개 행이 업데이트됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 리소스들을 생성 순서의 반대로 해제(close)
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
