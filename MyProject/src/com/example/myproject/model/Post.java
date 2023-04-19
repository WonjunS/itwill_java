package com.example.myproject.model;

import java.time.LocalDateTime;

public class Post {
	
	public interface Entity {
		String TBL_NAME = "POST";
		String COL_POST_ID = "POST_ID";
		String COL_TITLE = "TITLE";
		String COL_CONTENT = "CONTENT";
		String COL_WRITER = "WRITER";
		String COL_VIEWS = "VIEWS";
		String COL_LIKES = "LIKES";
		String COL_CREATED = "CREATED_TIME";
		String COL_MODIFIED = "MODIFIED_TIME";
		String COL_MEMBER_ID = "MEMBER_ID";
	}
	
	private int postId;
	private String title;
	private String content;
	private String writer;
	private int views;
	private int likes;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	private int memberId;
	
	public Post(int postId, String title, String content, String writer, int views, int likes,
			LocalDateTime createdTime, LocalDateTime modifiedTime, int memberId) {
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.views = views;
		this.likes = likes;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.memberId = memberId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
