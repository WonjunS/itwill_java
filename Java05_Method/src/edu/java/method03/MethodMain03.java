package edu.java.method03;

import java.util.Arrays;
import java.util.Random;

public class MethodMain03 {
	
	public static void main(String[] args) {
		
        // 배열 생성
        int[] array = makeTestArray(10);
        
        // 배열 출력
        printTestArray(array);
        
        // 배열의 모든 원소들의 합
        System.out.println("Sum = " + sum(array));
        
        // 배열의 모든 원소들의 평균
        System.out.println("Mean = " + mean(array));
        
        // 배열에서 최댓값
        System.out.println("Max = " + max(array));
        
        // 배열에서 최댓값의 인덱스
        System.out.println("MaxAt = " + maxAt(array));
        
        // 배열에서 최솟값
        System.out.println("Min = " + min(array));
        
        // 배열에서 최솟값의 인덱스
        System.out.println("MinAt = " + minAt(array));

    }
	
	public static int[] makeTestArray(int n) {
		int[] array = new int[n];
		
		Random random = new Random();
		for(int i = 0; i < n; i++) {
			array[i] = random.nextInt(101);
		}
		
		return array;
	}
	
	public static void printTestArray(int[] array) {
		System.out.println(Arrays.toString(array));
		
		// void 타입의 메서드에서는 return; 문을 생략해도 됨.
		return;
	}
    
    /**
     * sum
     * 정수 배열의 모든 원소들의 합을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 합.
     */
    public static int sum(int[] arr) {
    	int sum = 0;
    	for(int x : arr) {
    		sum += x;
    	}
    	return sum;
    }
    
    /**
     * mean
     * 정수 배열의 모든 원소들의 평균을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 평균.
     */
    public static double mean(int[] arr) {
    	return (double) sum(arr) / arr.length;
    }
    
    /**
     * max
     * 정수 배열에서 최댓값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값.
     */
    public static int max(int[] arr) {
    	int max = Integer.MIN_VALUE;
    	for(int x : arr) {
    		max = (x > max) ? x : max;
    	}
    	return max;
    }
    
    /**
     * maxAt
     * 정수 배열에서 최댓값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값의 인덱스.
     * 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스.
     */
    public static int maxAt(int[] arr) {
    	int idx = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] > arr[idx]) {
    			idx = i;
    		}
    	}
    	return idx;
    }

    /**
     * min
     * 정수 배열에서 최솟값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값.
     */
    public static int min(int[] arr) {
    	int min = Integer.MAX_VALUE;
    	for(int x : arr) {
    		min = (x < min) ? x : min;
    	}
    	return min;
    }
    
    /**
     * minAt
     * 정수 배열에서 최솟값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값의 인덱스.
     * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
     */
    public static int minAt(int[] arr) {
    	// 최솟값을 찾음
    	// 배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인지 검사
    	// 배열의 최솟값을 찾았으면 반복을 종료
    	// 반복문이 종료됐을 때의 인덱스를 리턴
    	int minValue = min(arr);
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] == minValue) {
    			return i;
    		}
    	}
    	return -1;
    }

}
