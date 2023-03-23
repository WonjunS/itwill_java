package edu.java.inheritance06;

public class UserTest {
	
	public static void main(String[] args) {
		User u1 = new User();
		System.out.println("u1: " + u1.toString());
		u1.setUserId("test1234");
		u1.setPassword("1234");
		System.out.println("u1: " + u1.toString());
		
		User u2 = new User("test1234", "1111");
		System.out.println("u2: " + u2.toString());
		System.out.println("== 연산자: " + (u1 == u2));
		System.out.println("equals() 메서드: " + (u1.equals(u2)));
		
		System.out.println("u1 hashCode: " + u1.hashCode());
		System.out.println("u2 hashCode: " + u2.hashCode());
	}

}
