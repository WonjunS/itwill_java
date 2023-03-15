package edu.java.class07;

public class Score {
    // 필드 - 객체의 속성(데이터)
    int java; // Java 과목 점수
    int sql; // SQL 과목 점수
    int html; // HTML 과목 점수
    
    // 생성자 - 객체 생성 & 속성 초기화
    // (1) 기본 생성자  (2) argument 3개를 갖는 생성자
    public Score() {}
    
    public Score(int java, int sql, int html) {
        this.java = java;
        this.sql = sql;
        this.html = html;
    }
    
    // 메서드 - 객체 기능
    // (1) printScore - 세 과목 점수 출력
    public void printScore() {
        System.out.println("Java: " + this.java);
        System.out.println("SQL: " + this.sql);
        System.out.println("HTML: " + this.html);
    }
    
    // (2) getTotal - 세 과목의 총점 리턴
    public int getTotal() {
        return this.java + this.sql + this.html;
    }
    
    // (3) getAverage - 세 과목의 평균(double) 리턴
    public double getAverage() {
        return (double) getTotal() / 3;
    }

}