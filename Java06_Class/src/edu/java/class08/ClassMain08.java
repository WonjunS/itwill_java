package edu.java.class08;

public class ClassMain08 {

    public static void main(String[] args) {
    	// Account1 계좌 생성
        Account account1 = new Account(123456, 1000);
        account1.deposit(10000);
        account1.printInfo();
        account1.withdraw(3000);
        account1.printInfo();
        
        // Account2 계좌 생성
        Account account2 = new Account(654321, 0);
        account2.deposit(3000);
        account2.printInfo();
        
        // 계좌 이체 테스트 (1)
        System.out.println("account1 -> account2 (2000)");
        account1.transfer(account2, 2000);
        account1.printInfo();
        account2.printInfo();
        
        // 계좌 이체 테스트 (2)
        System.out.println("account2 -> account2 (4500)");
        account2.transfer(account1, 4500);
        account1.printInfo();
        account2.printInfo();
        
        // 예외 사항 체크 (1)
        account2.withdraw(4000);
        account2.printInfo();
        
        // 예외 사항 체크 (2)
        account2.transfer(account1, 2000);
        account2.printInfo();
    }

}