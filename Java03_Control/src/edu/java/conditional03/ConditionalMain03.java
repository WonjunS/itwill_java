package edu.java.conditional03;

import java.util.Scanner;

public class ConditionalMain03 {

	public static void main(String[] args) {
		// 간단한 성적 처리 프로그램:
		
		// Ctrl + Space: 코드 추천
		// Ctrl + F11: 프로그램 실행
		Scanner sc = new Scanner(System.in); // 입력장치 Scanner를 사용할 준비 끝남.
		
		System.out.println("Java 점수>>> ");
		double java = sc.nextDouble();
		
		System.out.println("SQL 점수>>> ");
		double sql = sc.nextDouble();
		
		System.out.println("HTML 점수>>> ");
		double html = sc.nextDouble();
		
		double total = java + sql + html;
		System.out.println("총점: " + total + "점");
		
		double avg = total / 3;
		System.out.printf("평균: %.2f점\n", avg);
		
		if(avg >= 90) {
			System.out.println("학점: A");
		} else if(avg >= 80) {
			System.out.println("학점: B");
		} else if(avg >= 70) {
			System.out.println("학점: C");
		} else if(avg >= 60) {
			System.out.println("학점: D");
		} else {
			System.out.println("학점: F");
		}
	}

}
