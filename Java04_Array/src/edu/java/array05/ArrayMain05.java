package edu.java.array05;

import java.util.Random;

public class ArrayMain05 {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		final int size = 100;
		
		// int 10개를 저장할 수 있는 배열을 선언.
		int[] genderCodes = new int[size];
		
		// 배열에 난수(0, 1) 10개를 저장.
		Random random = new Random();
		for(int i = 0; i < genderCodes.length; i++) {
			int code = random.nextInt(2);
			genderCodes[i] = code;
		}
		
		// 배열의 내용을 출력.
		sb.append("Gender Codes: ").append('\t');
		
		for(int code : genderCodes) {
			sb.append(code).append('\t');
//			System.out.print(code + " ");
		}
		
//		System.out.println();
		sb.append('\n');
		
		// 문자열 10개를 저장할 수 있는 배열(genders)을 선언.
		String[] genders = new String[size];
		
		// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
		for(int i = 0; i < genderCodes.length; i++) {
			int code = genderCodes[i];
			genders[i] = (code == 0) ? "Male" : "Female";
		}
		
		// 문자열 배열 genders의 내용을 출력.
		sb.append("Genders: ").append('\t');
		
		for(String gender : genders) {
//			System.out.print(gender + " ");
			sb.append(gender).append('\t');
		}
		
//		System.out.println();
		sb.append('\n');
		
		// 문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력.
		int male = 0, female = 0;
		for(String gender : genders) {
			if(gender.equals("Male")) {
				male++;
				continue;
			}
			female++;
		}
		
//		System.out.println("Male = " + male + ", Female = " + female);
		
		sb.append("Male = " + male);
		sb.append(", Female = " + female);
		sb.append('\n');
		System.out.println(sb);
	}

}
