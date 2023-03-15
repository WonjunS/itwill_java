package edu.java.conditional06;

import java.util.Random;

public class ConditionalMain06 {

	public static void main(String[] args) {
		// Random 타입의 변수를 선언하고 초기화.
		// Java 과목 점수를 난수(0~100)로 만들어서 저장.
		// SQL 과목 점수를 난수(0~100)로 만들어서 저장.
		// HTML 과목 점수를 난수(0~100)로 만들어서 저장.
		// 합격/불합격 여부를 출력.
		// 합격 조건: 세 과목의 점수가 모두 40점 이상이고, 세 과목의 평균이 60점 이상.
		
		Random rdm = new Random();
		
		int java = rdm.nextInt(101); // 0 이상 101 미만의 난수를 생성.
		System.out.println("Java 점수 = " + java + "점");
		
		int sql = rdm.nextInt(101);
		System.out.println("SQL 점수 = " + sql + "점");
		
		int html = rdm.nextInt(101);
		System.out.println("HTML 점수 = " + html + "점");
		
		double avg = (double) (java + sql + html) / 3;
		System.out.printf("평균: %.2f점\n", avg);
		
		String passOrFail = 
				(java >= 40 && sql >= 40 && html >= 40 && avg >= 60.0) ? "합격" : "불합격";
		
		System.out.println(passOrFail);
	}

}
