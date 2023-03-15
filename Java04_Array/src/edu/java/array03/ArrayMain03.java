package edu.java.array03;

public class ArrayMain03 {
	
	public static void main(String[] args) {
		// Ex 1.
		// 정수(int) 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 0, 2, 4, 6, 8, 10, ..., 18을 저장.
		// 배열의 원소들을 한 줄로 출력.
		int[] array1 = new int[10];
		for(int i = 0; i < array1.length; i++) {
			array1[i] = i * 2;
		}
		
		for(int x : array1) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
		// Ex 2.
		// boolean 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 true, false, true, false, ..., false를 저장.
		// 배열의 원소들을 한 줄로 출력.
		boolean[] array2 = new boolean[10];
		for(int i = 0; i < array2.length / 2; i++) {
			array2[i * 2] = true; 
		}
		
		for(boolean x : array2) {
			System.out.print(x + " ");
		}
	}

}
