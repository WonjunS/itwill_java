package edu.java.modifier07;

public class Test {
	
	int x; // 인스턴스 필드
	static int y; // static 필드
	
	// 인스턴스 메서드
	public void printInfo() {
		System.out.println("--- instance method ---");
		System.out.println("x = " + this.x); // this. 생략 가능
		System.out.println("y = " + Test.y); // Test. 생략 가능
		// -> 인스턴스 메서드는 static 필드/메서드를 사용할 수 있음.
		System.out.println("-----------------------");
	}
	
	public static void printStaticInfo() {
		System.out.println("--- static method ---");
		// System.out.println("x = " + x);
		// -> static 메서드에서 인스턴스 필드/메서드를 사용할 수 없기 때문에
		System.out.println("y = " + y);
		System.out.println("---------------------");
	}

}
