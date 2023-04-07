package edu.java.inner02;

public class BuilderExample {
	
	public static void main(String[] args) {
		// Book 타입의 객체 생성
		Book book1 = new Book("하얼빈", "김훈", "문학동네");
		System.out.println(book1);
		
		Book book2 = new Book("홍길동전", "허균", "조선");
		System.out.println(book2);
		
		Book book3 = new Book("허균", "홍길동전", "모름");
		System.out.println(book3);
		
		Book book4 = Book.builder()
				.author("허균")
				.title("홍길동전")
				.build();
		System.out.println(book4);
		
		Book book5 = Book.builder()
				.publisher("문학동네")
				.title("하얼빈")
				.author("김훈")
				.build();
		System.out.println(book5);
	}

}
