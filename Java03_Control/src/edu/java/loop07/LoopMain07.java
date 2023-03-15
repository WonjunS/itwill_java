package edu.java.loop07;

public class LoopMain07 {
	
	public static void main(String[] args) {
		// 2중 반복문
		// for문을 사용한 구구단 출력
		for(int i = 2; i < 10; i++) {
			System.out.println("--- " + i + "단 ---");
			for(int j = 1; j < 10; j++) {
//				System.out.println(i + " x " + j + " = " + i * j);
				System.out.printf("%d x %d = %d\n", i, j, (i * j));
			}
		}
		
		System.out.println("\n============\n");
		
		
		// while문을 사용한 구구단 출력
		int x = 1;
		while(++x < 10) {
			System.out.println("--- " + x + "단 ---");
			int y = 0;
			while(++y < 10) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
			}
		}
	}
	
}
