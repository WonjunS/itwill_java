package edu.java.array09;

import java.util.Random;

public class ArrayMain09 {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
		final int size = 3;
		int[][] array = new int[size][];
		
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
		// 저장하는 난수의 범위는 0 이상 100 이하.
		Random random = new Random();
		
		int total_elements = 0;
		for(int i = 0; i < array.length; i++) {
			array[i] = new int[i + 2];
			for(int j = 0; j < array[i].length; j++) {
				int num = random.nextInt(101);
				array[i][j] = num;
				total_elements++;
			}
		}
		
        // 2차원 배열의 원소들을 출력.
		for(int[] arr : array) {
			for(int x : arr) {
				sb.append(x).append('\t');
			}
			sb.append('\n');
		}
		
        // 2차원 배열의 모든 원소들의 합을 계산하고 출력.
		int sum = 0;
		for(int[] arr : array) {
			for(int x : arr) {
				sum += x;
			}
		}
		
		sb.append("Sum = " + sum).append('\n');
		
        // 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
		double average = (double) sum / total_elements;
		sb.append("Average = " + String.format("%.2f", average)).append('\n');
		
        // 최댓값을 찾고 출력.
		int max = Integer.MIN_VALUE;
//		for(int i = 0; i < array.length; i++) {
//			for(int j = 0; j < array[i].length; j++) {
//				int x = array[i][j];
//				max = (x > max) ? x : max;
//			}
//		}
		
		for(int[] arr : array) {
			for(int x : arr) {
				max = (x > max) ? x : max;
			}
		}
		
		sb.append("Max = " + max).append('\n');
		
        // 최솟값을 찾고 출력.
		int min = Integer.MAX_VALUE;
//		for(int i = 0; i < array.length; i++) {
//			for(int j = 0; j < array[i].length; j++) {
//				int x = array[i][j];
//				min = Math.min(min, x);
//			}
//		}
		
		for(int[] arr : array) {
			for(int x : arr) {
				min = Math.min(min, x);
			}
		}
		
		sb.append("Min = " + min).append('\n');
		
		System.out.println(sb);
		
	}

}
