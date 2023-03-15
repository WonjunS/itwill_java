package edu.java.loop10;

import java.util.Scanner;

public class LoopMain10 {
	
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 || 2.출금 || 3.잔고 || 4.종료");
			System.out.println("---------------------------------");
			
			System.out.print("선택> ");
			int choice = sc.nextInt();

			switch(choice) {
			case 1:
				while(true) {
					System.out.print("예금액> ");
					int deposit = sc.nextInt();
					
					if(deposit <= 0) {
						System.out.println("예금액은 1원 이상이어야 합니다.");
					} else {
						balance += deposit;
					}
					break;
				}
				break;
			case 2:
				while(true) {
					System.out.print("출금액> ");
					int withdraw = sc.nextInt();
					if(withdraw <= 0) {
						System.out.println("출금액은 1원 이상이어야 합니다.");
					} else if(withdraw > balance) {
						System.out.println("출금액은 잔액을 초과할수 없습니다.");
					} else {
						balance -= withdraw;
					}
					break;
				}
				break;
			case 3:
				System.out.printf("잔고> %d\n", balance);
				break;
			case 4:
				System.out.println("\n프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력 값입니다.\n");
				continue;
			}
			
			System.out.println();
		}
	}
	
}
