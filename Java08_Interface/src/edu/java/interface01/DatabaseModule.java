package edu.java.interface01;

public interface DatabaseModule {
	
	// public static final 필드
	int DB_VERSION = 1; // -> public static final 생략
	
	// public abstract 메서드
	/**
	 * 데이터베이스 테이블에서 자료를 읽어서 검색하는 기능
	 * 
	 * @return 검색된 자료의 개수(int)
	 */
	int select(); // -> public abstract 생략
	
	/**
	 * 데이터베이스 테이블에 자료들을 저장하는 기능
	 * 
	 * @param strVal 저장할 문자열
	 * @param intVal 저장할 정수
	 * @return 테이블에 저장된 행(row)의 개수(int)
	 */
	int insert(String strVal, int intVal);

}
