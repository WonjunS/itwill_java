package edu.java.class07;

public class ClassMain07 {

    public static void main(String[] args) {
        // 기본 생성자를 사용해서 Score 객체 생성.
        Score score1 = new Score();
        System.out.println(score1);
        score1.printScore();

        // argument를 갖는 생성자를 호출해서 Score 객체를 생성.
        Score score2 = new Score(100, 90, 94);
        System.out.println(score2);
        score2.printScore();
        System.out.println("score2 총점: " + score2.getTotal());
        System.out.println("score2 평균: " + score2.getAverage());
        
        /*------------------------------*/
        String emptyString = "";
        System.out.println("길이: " + emptyString.length());
        String nullString = null;
        //System.out.println("길이: " + nullString.length());
        //-> NullPointerException 발생
        // null: 생성된 객체가 없다.
        // 데이터 타입의 기본값:
        // (1) boolean - false, (2) 정수 - 0, (3) 실수 - 0.0, (4) 참조(클래스) 타입 - null
        /*------------------------------*/
        
        // 기본 생성자를 사용해서 Student 객체를 생성.
        Student student1 = new Student();
        System.out.println(student1);
        student1.printStudent();
        
        Student student2 = new Student(1, "오쌤", score1);
        student2.printStudent();
        
        Student student3 = new Student(2, "김선아", score2);
        student3.printStudent();
        
        Student student4 = new Student(3, "이준혁", null);
        student4.printStudent();
        
        Student student5 = new Student(10, "위태욱", 100, 100, 100);
        student5.printStudent();
    }

}