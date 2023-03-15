package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

	public static void main(String[] args) {
		// 콘솔 창에서 키보드로 정수를 입력 받아서 변수에 저장하는 방법.
		// 1. Scanner 타입의 변수를 선언하고 초기화.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력>>> ");
		
		// 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 변수에 저장.
		int x = sc.nextInt();
		System.out.println("x = " + x);
		
		// 변수 y에 입력받은 정수를 저장.
		System.out.println("두번째 정수 입력>>> ");
		int y = sc.nextInt();
		
		// 입력받은 정수 y를 출력.
		System.out.println("y = " + y);
		
		// x + y, x - y, x * y, x / y, x % y 결과를 출력.
		// 사칙연산의 결과를 저장할 변수를 선언.
		int result = x + y;
		System.out.println("x + y = " + result);
		
		result = x - y;
		System.out.println("x - y = " + result);
		
		result = x * y;
		System.out.println("x * y = " + result);
		
		result = x / y;
		System.out.println("x / y = " + result);
		// 나누기 연산자:
		// 1. (정수) / (정수) = 나눈 몫
		// 2. (실수) / (실수) = 소수점까지 계산
		// (실수) / (정수) 또는 (정수) / (실수)도 2번 계산 결과와 같음.
		
		result = x % y;
		System.out.println("x % y = " + result);
	}

}
