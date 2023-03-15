package edu.java.array02;

public class ArrayMain02 {
	
	public static void main(String[] args) {
		// 문자열 3개를 저장할 수 있는 배열(names)을 선언, 초기화.
		String[] names = new String[3];
		
		// 배열 names에 문자열을 저장.
		names[0] = "a";
		names[1] = "b";
		names[2] = "c";
		
		// 배열 names의 내용 한 줄로 출력:
		// for 구문
		for(int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		
		System.out.println();
		
		// for-each 구문
		for(String name : names) {
			System.out.print(name + " ");
		}
		
		System.out.println();
		
		String[] subjects = {"Java", "SQL", "HTML", "JavaScript"};
		for(String subject : subjects) {
			System.out.print(subject + " ");
		}
		
		System.out.println();
	}

}
