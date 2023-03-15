package edu.java.array04;

import java.util.Random;

public class ArrayMain04 {
	
	public static void main(String[] args) {
        // 정수 5개를 저장할 수 있는 배열을 선언.
		int[] numbers = new int[5];
		
        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
        // 배열의 모든 원소의 합을 계산하고 출력.
		Random random = new Random();
		
		
		int sum = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			int n = random.nextInt(10);
			numbers[i] = n;
			System.out.print(numbers[i] + " ");
			
			sum += n;
		}
		
		System.out.println();
		
		System.out.printf("sum = %d\n", sum);
		
        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		double average = (double) sum / numbers.length;
		
		System.out.printf("average = %.1f\n", average);
		
		// 배열의 원소들 중 최댓값을 찾고 출력
		int max = Integer.MIN_VALUE; // 최댓값 지정
		for(int x : numbers) { // 배열 numbers의 모든 원소들을 순회하면서
//			if(x > max) max = x; // 배열에서 읽은 값이 max보다 크다면 max의 값을 x로 변경
			max = (x > max) ? x : max;
//			max = Math.max(max, x);
		}
		
		System.out.println("max = " + max);
		
		// 배열의 원소들 중 최솟값을 찾고 출력
		int min = Integer.MAX_VALUE; // 최솟값 지정
		for(int x : numbers) { // 배열의 모든 원소를 순서대로 반복하면서
			if(x < min) min = x; // 배열에서 읽은 값이 min보다 작다면 min의 값을 x로 변경
//			min = (x < min) ? x : min;
//			min = Math.min(min, x);
		}
		
		System.out.println("min = " + min);
    }

}
