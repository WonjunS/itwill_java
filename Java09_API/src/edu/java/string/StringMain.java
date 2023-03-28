package edu.java.string;

import java.util.Arrays;

public class StringMain {
	
	public static void main(String[] args) {
		// Ex 1. 아래에 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력
		System.out.println("--- Ex 1 ---");
		String ssn = "991231-1234567";
		System.out.println(ssn.charAt(7));
		
		// Ex 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력
		System.out.println("\n--- Ex 2 ---");
		String[] names = {"오쌤", "John", "Jane", "홍길동", "허균", "홍길동"};
		System.out.println(Arrays.asList(names).indexOf("홍길동"));
		
		// Ex 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력
		System.out.println("\n--- Ex 3 ---");
		String[] languages = {"Java", "SQL", "HTML", "CSS", "JavaScript", "Python"};
		for(String language : languages) {
			if(language.length() >= 5) 
				System.out.println(language);
		}
		
		// Ex 4. 아래의 문자열 배열에서 대소문자 구별 없이 "est"가 포함된 문자열들을 찾아서 출력
		System.out.println("\n--- Ex 4 ---");
		String[] test = {"TEST", "test", "TeSt", "tEST", "테스트"};
		for(int i = 0; i < test.length; i++) {
			String s = test[i].toLowerCase();
			if(s.contains("est")) 
				System.out.println(test[i]);
		}
		
		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 연/월/일 정보를 int 타입 변수에 저장하고 출력
		System.out.println("\n--- Ex 5 ---");
		String date = "2023-03-22";
		String[] str = date.split("-");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int day = Integer.parseInt(str[2]);
		
		System.out.printf("year = %d, month = %d, day = %d\n", year, month, day);
	}

}
