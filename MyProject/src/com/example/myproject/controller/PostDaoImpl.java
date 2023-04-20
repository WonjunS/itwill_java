package com.example.myproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.myproject.model.Post;

import oracle.jdbc.OracleDriver;

import static com.example.myproject.ojdbc.OracleConnect.*;
import static com.example.myproject.model.Post.Entity.*;

public class PostDaoImpl implements PostDao {
	
	private static PostDaoImpl instance = null;
	
	private PostDaoImpl() {}
	
	public static PostDaoImpl getInstance() {
		if(instance == null) {
			instance = new PostDaoImpl();
		}
		
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	private static final String SQL_SELECT_BY_ID =
			"select * from " + TBL_NAME
			+ " where " + COL_POST_ID + " = ?";

	@Override
	public Post read(int id) {
		Post post = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				int postId = rs.getInt(COL_POST_ID);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String writer = rs.getString(COL_WRITER);
				int views = rs.getInt(COL_VIEWS);
				int likes = rs.getInt(COL_LIKES);
				LocalDateTime created = rs.getTimestamp(COL_CREATED).toLocalDateTime();
				LocalDateTime modified = rs.getTimestamp(COL_MODIFIED).toLocalDateTime();
				int memberId = rs.getInt(COL_MEMBER_ID);
				
				post = new Post(postId, title, content, writer, views, likes, created, modified, memberId);
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
		
		return post;
	}
	
	private static final String SQL_SELECT_ALL =
			"select * from " + TBL_NAME
			+ " order by " + COL_POST_ID + " desc";

	@Override
	public List<Post> read() {
		List<Post> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				int postId = rs.getInt(COL_POST_ID);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String writer = rs.getString(COL_WRITER);
				int views = rs.getInt(COL_VIEWS);
				int likes = rs.getInt(COL_LIKES);
				LocalDateTime created = rs.getTimestamp(COL_CREATED).toLocalDateTime();
				LocalDateTime modified = rs.getTimestamp(COL_MODIFIED).toLocalDateTime();
				int memberId = rs.getInt(COL_MEMBER_ID);
				
				Post post = new Post(postId, title, content, writer, views, likes, created, modified, memberId);
				
				list.add(post);
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
		
		return list;
	}
	
	private static final String SQL_SELECT_BY_KEYWORD =
			"select * from " + TBL_NAME
			+ " where lower(" + COL_TITLE + ") like lower(?)"
			+ " order by " + COL_POST_ID + " desc";
	
	@Override
	public List<Post> read(String searchBy, String keyword) {
		List<Post> list = new ArrayList<>();
		
		final String SQL_SELECT_BY_KEYWORD =
				"select * from " + TBL_NAME
				+ " where lower(" + searchBy + ") like lower(?)"
				+ " order by " + COL_POST_ID + " desc";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);
			keyword = "%" + keyword + "%";
			stmt.setString(1, keyword);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				int postId = rs.getInt(COL_POST_ID);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String writer = rs.getString(COL_WRITER);
				int views = rs.getInt(COL_VIEWS);
				int likes = rs.getInt(COL_LIKES);
				LocalDateTime created = rs.getTimestamp(COL_CREATED).toLocalDateTime();
				LocalDateTime modified = rs.getTimestamp(COL_MODIFIED).toLocalDateTime();
				int memberId = rs.getInt(COL_MEMBER_ID);
				
				Post post = new Post(postId, title, content, writer, views, likes, created, modified, memberId);
				
				list.add(post);
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
		
		return list;
	}
	
	private static final String SQL_SELECT_BY_MEMBER =
			"select * from " + TBL_NAME
			+ " where " + COL_MEMBER_ID + " = ?";
	
	@Override
	public List<Post> readByMemberId(int id) {
		List<Post> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_MEMBER);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				int postId = rs.getInt(COL_POST_ID);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String writer = rs.getString(COL_WRITER);
				int views = rs.getInt(COL_VIEWS);
				int likes = rs.getInt(COL_LIKES);
				LocalDateTime created = rs.getTimestamp(COL_CREATED).toLocalDateTime();
				LocalDateTime modified = rs.getTimestamp(COL_MODIFIED).toLocalDateTime();
				int memberId = rs.getInt(COL_MEMBER_ID);
				
				Post post = new Post(postId, title, content, writer, views, likes, created, modified, memberId);
				
				list.add(post);
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
		
		return list;
	}
	
	private final String SQL_INSERT = 
			"insert into " + TBL_NAME
			+ " (" + COL_TITLE + ", " + COL_CONTENT + ", " + COL_WRITER + ", " + COL_VIEWS + ", " + COL_LIKES
			+ ", " + COL_CREATED + ", " + COL_MODIFIED + ", " + COL_MEMBER_ID + ")"
			+ " values(?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public int create(Post post) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getContent());
			stmt.setString(3, post.getWriter());
			stmt.setInt(4, post.getViews());
			stmt.setInt(5, post.getLikes());
			stmt.setTimestamp(6, Timestamp.valueOf(post.getCreatedTime()));
			stmt.setTimestamp(7, Timestamp.valueOf(post.getModifiedTime()));
			stmt.setInt(8, post.getMemberId());
			
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
	
	private final String SQL_UPDATE = 
			"update " + TBL_NAME
			+ " set " + COL_TITLE + " = ?, " + COL_CONTENT + " = ?, " + COL_MODIFIED + " = ?"
			+ " where " + COL_POST_ID + " = ?";

	@Override
	public int update(Post post) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getContent());
			stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			stmt.setInt(4, post.getPostId());
			
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
	
	private final String SQL_UPDATE_VIEW = 
			"update " + TBL_NAME
			+ " set " + COL_VIEWS + " = ?"
			+ " where " + COL_POST_ID + " = ?";
	
	@Override
	public int updateView(Post post) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_UPDATE_VIEW);
			stmt.setInt(1, post.getViews() + 1);
			stmt.setInt(2, post.getPostId());
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
	
	private final String SQL_DELETE = 
			"delete from " + TBL_NAME
			+ " where " + COL_POST_ID + " = ?";

	@Override
	public int delete(int postId) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, postId);
			
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

}
