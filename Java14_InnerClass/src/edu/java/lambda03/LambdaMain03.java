package edu.java.lambda03;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class LambdaMain03 {
	
	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList(
				new Employee(100, "emp_a", "개발1팀", "대리", 400),
				new Employee(101, "emp_b", "개발2팀", "사원", 350),
				new Employee(200, "emp_c", "개발2팀", "과장", 380),
				new Employee(201, "emp_d", "개발1팀", "부장", 500),
				new Employee(300, "emp_e", "인사팀", "사원", 300),
				new Employee(301, "emp_f", "인사팀", "과장", 450)
		);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("--------------------------------");
		
		// 2. 개발1,2팀에서 일하는 직원들의 급여의 합계를 출력
		double sum = employees.stream()
				.filter(e -> (e.getDept().contains("개발")))
				.mapToDouble(x -> x.getSalary())
				.sum();
		
		System.out.println("개발팀 급여 합계 = " + sum);
		
		System.out.println("--------------------------------");
		
		// 3. 개발1,2팀에서 일하는 직원들의 급여의 평균을 출력
		double avg = employees.stream()
				.filter(e -> (e.getDept().contains("개발")))
				.mapToDouble(x -> x.getSalary())
				.average()
				.orElseThrow();
		
		System.out.println("개발팀 평균 급여 = " + avg);
		
		System.out.println("--------------------------------");
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력
		sum = employees.stream()
				.filter(e -> (e.getEmpTitle().equals("사원")))
				.mapToDouble(x -> x.getSalary())
				.sum();
		
		System.out.println("사원 급여 합계 = " + sum);
		
		System.out.println("--------------------------------");
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력
		avg = employees.stream()
				.filter(e -> (e.getEmpTitle().equals("사원")))
				.mapToDouble(x -> x.getSalary())
				.average()
				.orElseThrow();
		
		System.out.println("사원 평균 급여 = " + avg);
		
		System.out.println("--------------------------------");
		
		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력
		employees.stream()
				.filter(e -> (e.getSalary() >= 400))
				.forEach(System.out::println);
		
		System.out.println("--------------------------------");
		
		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력
		avg = employees.stream()
				.filter(e -> (e.getDept().equals("개발1팀")))
				.mapToDouble(e -> e.getSalary() * 1.1)
				.average()
				.orElseThrow();
		
		System.out.println("개발1팀 평균 급여 = " + avg);
		
		System.out.println("--------------------------------");
		
		// 8. 직원 리스트에서 "사원"은 몇 명?
		long count = employees.stream()
				.filter(e -> (e.getEmpTitle().equals("사원")))
				.count();
		
		System.out.println("사원 수 = " + count);
	}

}
