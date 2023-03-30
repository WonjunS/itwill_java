package edu.java.set03;

import java.util.HashSet;
import java.util.Set;

public class SetMain03 {
	
	public static void main(String[] args) {
		// Set<E>은 중복된 값을 저장하지 않음.
		Set<String> set = new HashSet<>();
		set.add("hello");
		set.add("olleh");
		set.add("hello");
		
		System.out.println(set);
		
		Set<Score> scores = new HashSet<>();
		
		Score score1 = new Score(100, 100, 100);
		scores.add(score1);
		
		Score score2 = new Score(100, 90, 80);
		System.out.println("score1 score2 eq? " + score1.equals(score2));
		scores.add(score2);
		
		Score score3 = new Score(100, 100, 100);
		System.out.println("score1 score3 eq? " + score1.equals(score3));
		scores.add(score3);
		// -> (1) equals만 override를 하고 hashCode를 override하지 않으면 score3이 Set에 추가됨
		// -> (2) equals와 hashCode를 모두 적절하게 override하면 score3은 Set에 추가되지 않음
		
		// equals()가 true이면 hashCode() 리턴 값이 같다
		// hashCode() 리턴 값이 다르면 equals()가 false이다
		// Set은 두 객체의 중복 여부(같은지 다른지) 여부를 검사할 때 hashCode()를 먼저 비교하고,
		// hashCode()가 같으면 equals() 메서드를 호출해서 중복여부를 검사함
		
		
		System.out.println(scores);
	}

}
