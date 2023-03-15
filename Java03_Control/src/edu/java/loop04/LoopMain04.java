package edu.java.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
		// 반복문에서 break와 continue
		
		for(int i = 1; i <= 5; i++) {
			if(i == 3) break;
			// break가 포함된 가장 가까운 반복문을 종료.
			
			System.out.println(i);
		}
		
		System.out.println("==========");
		
		for(int i = 1; i <= 5; i++) {
			if(i == 3) continue;
			// continue 아래의 코드들은 실행하지 않고, 그 다음 반복을 계속해서 수행
			
			System.out.println(i);
		}
	}

}
