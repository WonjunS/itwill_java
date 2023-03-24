package edu.java.mvc.controller;

import edu.java.mvc.model.Post;

public class PostDaoImpl implements PostDao {
	
	private static PostDaoImpl instance = null;
	
	private PostDaoImpl() {}
	
	public static PostDaoImpl getInstance() {
		if(instance == null) {
			instance = new PostDaoImpl();
		}
		
		return instance;
	}
	
	// fields
	private static final int MAX_LENGTH = 5;
	private Post[] posts = new Post[MAX_LENGTH];
	private int count = 0;
	
	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}
	
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < count);
	}

	@Override
	public int create(Post p) {
		if(!isMemoryAvailable()) {
			return 0;
		}
		posts[count++] = p;
		return 1;
	}

	@Override
	public Post[] read() {
		Post[] array = new Post[count];
		
		for(int i = 0; i < count; i++) {
			array[i] = posts[i];
		}
		
		return array;
	}

	@Override
	public Post read(int index) {
		if(!isValidIndex(index)) {
			return null;
		}
		return posts[index];
	}

	@Override
	public int update(int index, Post p) {
		if(!isValidIndex(index)) {
			return 0;
		}
		posts[index] = p;
		return 1;
	}

	@Override
	public int delete(int index) {
		if(!isValidIndex(index)) {
			return 0;
		}
		for(int i = index; i < count - 1; i++) {
			posts[i] = posts[i + 1];
		}
		posts[count] = null;
		count--;
		return 1;
	}
	
}
