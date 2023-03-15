package edu.java.homework;

public class Homework02 {
	
	public static void main(String[] args) {
		// 369 게임 출력
        /* 실행 결과
            1   2   *   4   5   *   7   8   *   10  
            11  12  *   14  15  *   17  18  *   20  
            21  22  *   24  25  *   27  28  *   *   
            *   *   *   *   *   *   *   *   *   40  
            41  42  *   44  45  *   47  48  *   50  
            51  52  *   54  55  *   57  58  *   *   
            *   *   *   *   *   *   *   *   *   70  
            71  72  *   74  75  *   77  78  *   80  
            81  82  *   84  85  *   87  88  *   *   
            *   *   *   *   *   *   *   *   *   100
         */
		
		for(int i = 0; i < 10; i++) {
			for(int j = 1; j <= 10; j++) {
				int num = (10 * i) + j;
				String str = String.valueOf(num);
				
				// 숫자를 출력할 것인지, "*"를 출력할 것인지.
//				if(str.contains("3") || str.contains("6") || str.contains("9")) {
//					System.out.print("*\t");
//				}
				
				boolean condition1 = (num % 10 == 3) || (num % 10 == 6) || (num % 10 == 9);
				boolean condition2 = (num / 10 == 3) || (num / 10 == 6) || (num / 10 == 9);
				
				if(condition1 && condition2) {
					System.out.print("**\t");
				}
				else if(condition1 || condition2) {
					System.out.print("*\t");
				}
				else {
					System.out.print(num + "\t");
				}
			}
			System.out.println();
		}
	}

}
