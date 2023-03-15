package edu.java.loop08;

public class LoopMain08 {
	
	public static void main(String[] args) {
		// 구구단 2단은 2x2까지, 3단은 3x3까지, 4단은 4x4까지, ... , 9단은 9x9까지 출력
		for(int i = 2; i <= 9; i++) {
			System.out.println("--- " + i + "단 ---");
			for(int j = 1; j <= i; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i * j);
			}
		}
		
		System.out.println("\n============\n");
		
		int x = 2;
		while(x < 10) {
			System.out.println("--- " + x + "단 ---");
			
			int y = 1;
			
//			boolean run = true;
//			while(run) {
//				System.out.printf("%d x %d = %d\n", x, y, x * y);
//				if(y == x) run = false;
//				y++;
//			}
//			while(y <= x) {
//				System.out.printf("%d x %d = %d\n", x, y, x * y);
//				y++;
//			}
			while(y < 10) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
				if(y == x) break;
				y++;
			}
			x++;
		}
	}
	
}
