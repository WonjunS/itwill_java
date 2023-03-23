package edu.java.inheritance03;

// 하이브리드 자동차는 자동차이다.(IS-A 관계)
public class HybridCar extends Car {
	
	// field
	private int battery;

	// constructor
	public HybridCar(double fuel, double speed, int battery) {
		super(fuel, speed);
		// -> 상위 클래스에 기본 생성자가 없기 때문에, 
		// 반드시 argument를 갖는 super 생성자를 명시적으로 호출해야 한다.
		// 하위 클래스 필드를 초기화하는 코드는 super 생성자 호출 이후에 작성
		this.battery = battery;
	}
	
	@Override
	public void drive() {
//		System.out.printf("하이브리드 자동차 운전: 속력=%.1f, 연료=%.1f, 배터리=%d\n",
//				this.getSpeed(), this.getFuel(), this.battery);
		super.drive(); // 상위 타입 객체가 가지고 있는 (override 전) 메서드를 호출
		System.out.println("--- 배터리=" + battery);
	}
	
	// 메서드/생성자 overloading:
	// 파라미터가 다를 때, 같은 이름으로 메서드/생성자를 여러개 작성하는 것.
	
	// 메서드 overriding:
	// 상위 클래스의 메서드를 하위 클래스에서 재정의하는 것.
	// 리턴 타입, 메서드 이름, 파라미터 선언이 모두 같아야 함.
	// 접근 제한 수식어는 상위 클래스의 수식어보다 범위가 넓거나 같으면 됨.
	
}
