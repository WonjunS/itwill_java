package edu.java.loop09;

import java.util.Random;

public class LoopMain09 {

	public static void main(String[] args) {
		/*
		 문제 1. 아래와 같이 출력하세요.
		 	*
		 	**
		 	***
		 	****
		 	*****
		*/

		// (1)
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// Ctrl+Shift+F: 코드 포맷팅(자동 정렬)

		// (2)
//		int m = 1;
//		while(m <= 5) {
//			int n = 1;
//			while(n <= m) {
//				System.out.print("*");
//				n++;
//			}
//			System.out.println();
//			m++;
//		}

		System.out.println("\n==========\n");

		/*
		 문제 2. 아래와 같이 출력하세요.
		 	*
		 	**
		 	***
		 	****
		 	*****
		 	****
		 	***
		 	**
		 	*
		*/

		// (1)
		for (int i = 1; i <= 9; i++) {
			int len = 5 - Math.abs(5 - i);
			for (int j = 1; j <= len; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// (2)
//		for(int i = 1; i <= 5; i++) {
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		for(int i = 4; i >= 1; i--) {
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		System.out.println("\n==========\n");

		/*
		 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요.
		 두 눈의 합이 5가 되면 출력을 멈추세요.
		 힌트: Random 타입의 nextInt(start, end) 메서드를 사용.
		 출력 결과 예시:
		  (2, 4)
		  (6, 1)
		  (3, 3)
		  (4, 1)
		*/

		Random random = new Random();
		
//		for( ; ; ) {
//			int x = random.nextInt(1, 7);
//			int y = random.nextInt(1, 7);
//
//			System.out.printf("(%d, %d)\n", x, y);
//
//			if (x + y == 5) {
//				break;
//			}
//		}
		
		boolean run = true;
		while (run) {
			int x = random.nextInt(1, 7);
			int y = random.nextInt(1, 7);

			System.out.printf("(%d, %d)\n", x, y);

			int sum = x + y;
			if (sum == 5) {
				run = false;
			}
		}
	}

}
