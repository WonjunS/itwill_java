package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {
	
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO inputInteger() 메서드 테스트 코드
		ExceptionMain06 app = new ExceptionMain06();
		
		int input = app.inputInteger();
		System.out.println("Input = " + input);
	}
	
	public int inputInteger() {
		// TODO Scanner를 사용해서 입력받은 정수를 리턴
		// Integer.parseInt(sc.nextLine()) 과정에서 NumberFormatException이 발생할 수 있음
		
		int input = 0;
		boolean run = true;
		while(run) {
			try {
				System.out.print("정수 입력> ");
				input = Integer.parseInt(sc.nextLine());
				run = false;
			} catch(NumberFormatException e) {
				System.out.println("정수를 입력해주세요.");
			}
		}
		
		return input;
	}

}
