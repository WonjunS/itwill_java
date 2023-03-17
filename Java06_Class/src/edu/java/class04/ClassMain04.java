package edu.java.class04;

public class ClassMain04 {
	
	public static void main(String[] args) {
		Product product1 = new Product();
		product1.setProductPrice(10000);
		product1.printProductInfo();
		
		Product product2 = new Product(1, "Product A", 5000);
		product2.printProductInfo();
		
		Product product3 = new Product(2, "Product B");
		product3.printProductInfo();
		product3.setProductPrice(7000);
		product3.printProductInfo();
		
	}

}
