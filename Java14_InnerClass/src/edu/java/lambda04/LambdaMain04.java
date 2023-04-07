package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {
	
	public static void main(String[] args) {
		LambdaMain04 app = new LambdaMain04();
		
		List<Object> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Object> odds = app.filter(list, new MyFilter() {
			@Override
			public boolean check(Object x) {
				return ((Integer) x) % 2 == 1;
			}
		});
		
		List<Object> evens = app.filter(list, x -> ((Integer) x) % 2 == 0);
		
		List<Object> squares = app.mapper(list, x -> (int) Math.pow((Integer) x, 2));
		
		List<Object> result = app.mapper(list, x -> (Integer) x + 10);
		
		System.out.println(odds);
		System.out.println(evens);
		System.out.println(squares);
		System.out.println(result);
		
	}
	
	public List<Object> filter(List<Object> list, MyFilter func) {
		List<Object> result = new ArrayList<>();
		for(Object x : list) {
			if(func.check(x)) {
				result.add(x);
			}
		}
		
		return result;
	}
	
	public List<Object> mapper(List<Object> list, MyMapper func) {
		List<Object> result = new ArrayList<>();
		for(Object x : list) {
			result.add(func.transform(x));
		}
		
		return result;
	}

}
