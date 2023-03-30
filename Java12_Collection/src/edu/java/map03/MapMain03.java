package edu.java.map03;

import java.util.HashMap;
import java.util.Map;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting):
        // 문자열에 등장하는 단어를 key로 하고, 그 단어의 등자 횟수를 value로 하는 Map을 만들고 출력하세요.
        // 결과> {하늘=3, 땅=2, sky=2}
        String sentence = "하늘 땅 하늘 땅 하늘 sky sky";
        String[] str = sentence.split("\\s+");
        
        Map<String, Integer> map = new HashMap<>();
        for(String word : str) {
        	map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        System.out.println(map);

    }

}