package edu.java.mvc.controller;

import edu.java.mvc.model.Post;

public interface PostDao {
	
	int create(Post p);
	
	Post[] read();
	
	Post read(int index);
	
	int update(int index, Post p);
	
	int delete(int index);
	
}
