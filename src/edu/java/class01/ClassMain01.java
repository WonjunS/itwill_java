package edu.java.class01;

// 객체 지향 프로그래밍(Object-Oriented Programming): Java, C++, C#, ...
// 절차 지향 프로그래밍(Procedural Programming): C, ...
// 객체(Object): 대상. 프로그램에서 사용하려는 대상.
// 인스턴스(Instance): 실제로 만들어진(생성된) 객체.
// 클래스(Class): object를 설계한 코드.
// -> 객체가 가질수 있는 데이터(값)를 변수로 선언하고,
// -> 객체가 가질수 있는 기능들을 메서드로 정의한 코드.
// -> 데이터 타입(변수를 선언할 때 사용).

public class ClassMain01 {
	
	public static void main(String[] args) {
		String s1 = "hello, java";
		String s2 = new String("안녕하세요.");
		
		System.out.println("s1 길이 = " + s1.length());
		System.out.println("s2 길이 = " + s2.length());
		System.out.println(s1.concat("!!!"));
		System.out.println(s2.concat("..."));
		
	}

}
