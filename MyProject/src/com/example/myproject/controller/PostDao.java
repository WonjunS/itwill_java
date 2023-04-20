package com.example.myproject.controller;

import java.util.List;

import com.example.myproject.model.Post;

public interface PostDao {
	
	/**
	 * 특정 게시물 검색
	 * 
	 * @param postId 검색할 primary key
	 * @return 
	 */
	Post read(int postId);
	
	/**
	 * 전체 게시물 검색
	 * DB post 테이블에 저장된 모든 게시물 정보를 검색
	 * 
	 * @return Post 타입을 원소로 갖는 List
	 */
	List<Post> read();
	
	/**
	 * 주어진 검색어가 포함된 게시물을 찾기
	 * 
	 * @param searchBy 검색 기준(제목, 내용, 작성자)
	 * @param keyword 검색어
	 * @return Post 타입을 원소로 갖는 List
	 */
	List<Post> read(String searchBy, String keyword);
	
	/**
	 * 특정 회원이 작성한 게시물을 찾기
	 * 
	 * @param memberId 회원의 PK
	 * @return Post 타입을 원소로 갖는 List
	 */
	List<Post> readByMemberId(int memberId);
	
	/**
	 * DB의 post 테이블에 게시물을 저장
	 * 
	 * @param post
	 * @return DB 테이블에 삽입된 행의 개수
	 */
	int create(Post post);
	
	/**
	 * 게시물의 제목과 내용을 업데이트
	 * 
	 * @param post 수정할 정보를 가지고 있는 객체
	 * @return DB 테이블에서 업데이트된 행의 개수
	 */
	int update(Post post);
	
	/**
	 * 게시물의 조회수를 업데이트
	 * 
	 * @param post 수정할 정보를 가지고 있는 객체
	 * @return DB 테이블에서 업데이트된 행의 개수
	 */
	int updateView(Post post);
	
	/**
	 * Primary key에 해당하는 게시물 정보를 DB 테이블에서 삭제
	 * 
	 * @param postId 삭제할 Post 객체의 PK 값
	 * @return 삭제된 행의 개수
	 */
	int delete(int postId);

}
