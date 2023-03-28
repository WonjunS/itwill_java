package edu.java.contact.menu;

public enum Menu {
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	
	public static Menu getValue(int n) {
		Menu[] menus = values();
		// -> values(): 모든 enum 클래스가 갖고 있는 static 메서드
		// -> values의 리턴 값: enum에서 정의한 열거형 상수들의 배열
		// -> {QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN}
		int len = menus.length;
		
		if(n >= 0 && n < len - 1) {
			return menus[n];
		}
		
		return menus[len - 1]; // UNKNOWN
	}
	
}
