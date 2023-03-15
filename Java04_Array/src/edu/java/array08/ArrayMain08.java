package edu.java.array08;

public class ArrayMain08 {
	
	public static void main(String[] args) {
		// 1차원 배열 선언 초기화 (1): type[] array = { ... };
		// 1차원 배열 선언 초기화 (2): type[] array = new type[개수];
		
		// 2차원 배열 선언 초기화 (1): type[][] array = { {...}, {...}, ... };
		// 2차원 배열 선언 초기화 (2): type[][] array = new type[행의 개수][열의 개수];
		// new type[2차원 배열의 원소의 개수][1차원 배열의 원소의 개수]
		
		int[][] array1 = new int[3][4];	
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array1[i].length; j++) {
				array1[i][j] = (i * 4) + j + 1;
			}
		}
		
		for(int[] arr : array1) {
			for(int x : arr) {
				System.out.print(x + "\t");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		
		// 2차원 배열을 선언하고 생성할 때 행의 개수(2차원 배열의 원소의 개수)는 반드시 필요함.
		// 2차원 배열의 열의 개수(각각의 1차원 배열의 원소 개수)는 나중에 설정할 수 있음.
		
		int[][] array2 = new int[3][];
		array2[0] = new int[3];
		array2[1] = new int[4];
		array2[2] = new int[2];
		
		for(int i = 0; i < array2.length; i++) {
			for(int j = 0; j < array2[i].length; j++) {
				array2[i][j] = (i * 3) + j + 1;
			}
		}
		
		for(int[] arr : array2) {
			for(int x : arr) {
				System.out.print(x + "\t");
			}
			System.out.println();
		}
	}

}
