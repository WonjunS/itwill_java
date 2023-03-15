package edu.java.array06;

import java.util.Arrays;

public class ArrayMain06 {
	
	public static void main(String[] args) {
		// 문자열 1차원 배열
		String[] newJeans = {"민지", "하니", "다니엘", "해린", "혜인"};
		String[] sosi = {"태연", "윤아", "티파니", "수영"};
		String[] bts = {"정국", "뷔", "RM", "지민", "슈가", "제이홉", "진"};
		
		// 문자열 2차원 배열: 문자열 배열들을 원소로 갖는 배열.
		String[][] idols = {newJeans, sosi, bts};
		
		// 2차원 배열에서 length의 의미:
		System.out.println(idols.length); // 아이돌 그룹의 개수
		System.out.println(idols[0].length); // 첫번째 아이돌 그룹의 멤버 수
		System.out.println(idols[1].length); // 두번째 아이돌 그룹의 멤버 수
		
		for(int i = 0; i < idols.length; i++) {
			for(int j = 0; j < idols[i].length; j++) {
				System.out.print(idols[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------------------");
		
		// for-each 구문을 사용한 2차원 배열 출력
		for(String[] group : idols) {
			for(String member : group) {
				System.out.print(member + "\t");
			}
			System.out.println();
		}
		
	}

}
