package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        Circle c1 = new Circle(); // 기본 생성자 호출
        c1.printInfo();
        System.out.println("둘레: " + c1.perimeter()); 
        System.out.println("넓이: " + c1.area());
        
        Circle c2 = new Circle(1.0); // argument를 갖는 생성자 호출
        c2.printInfo();
        System.out.println("둘레: " + c2.perimeter());
        System.out.println("넓이: " + c2.area());

    }

}