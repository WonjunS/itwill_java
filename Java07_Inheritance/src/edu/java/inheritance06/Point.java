package edu.java.inheritance06;

import java.util.Objects;

public class Point {
	
	// field
	private int x;
	private int y;
	
	// constructor
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// getters & setters
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	// toString
	@Override
	public String toString() {
//		return "Point(x=" + this.x + ", y=" + this.y + ")";
		return String.format("Point(x=%d, y=%d)", this.x, this.y);
	}

	@Override
	// hashCode() 메서드는 반드시 int 타입을 리턴
	// equals()가 true를 리턴하는 두 객체는 hashCode()의 리턴값이 같아야 함
	public int hashCode() {
		return x * 100 + y * 10;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) { // obj가 Point 타입의 인스턴스이면
			Point other = (Point) obj; // 안전한 타입 변환(casting)
			return (this.x == other.x) && (this.y == other.y);
		} else {
			return false;
		}
	}

}
