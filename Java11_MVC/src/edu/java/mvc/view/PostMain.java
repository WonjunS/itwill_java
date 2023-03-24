package edu.java.mvc.view;

import java.util.Scanner;

import edu.java.mvc.controller.PostDaoImpl;
import edu.java.mvc.menu.Menu;

public class PostMain {
	
	private final Scanner sc = new Scanner(System.in);
	private final PostDaoImpl dao = PostDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("--- 블로그 프로그램 ---");
        
        PostMain app = new PostMain();
        
        boolean run = true;
        while(run) {
        	int n = app.showMainMenu();
        	Menu menu = Menu.getValue(n);
        	switch(menu) {
        	case EXIT:
        		run = false;
        		break;
        	case CREATE:
        		app.createNewPost();
        		break;
        	case READ_ALL:
        		app.readAllPosts();
        		break;
        	case READ_BY_INDEX:
        		app.readAllByIndex();
        		break;
        	case UPDATE:
        		app.updatePost();
        		break;
        	case DELETE:
        		app.deletePost();
        		break;
    		default:
    			System.out.println("메인 메뉴 번호를 확인하세요...");
        	}
        }
    }
    
    private void deletePost() {
		// TODO Auto-generated method stub
		
	}

	private void updatePost() {
		// TODO Auto-generated method stub
		
	}

	private void readAllByIndex() {
		// TODO Auto-generated method stub
		
	}

	private void readAllPosts() {
		// TODO Auto-generated method stub
		
	}

	private void createNewPost() {
		
		
	}
	
	private int showMainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("-------------------------------------------------");
		System.out.print("선택> ");
		int n = inputNumber();
		
		return n;
	}

	private int inputNumber() {
    	while(true) {
    		try {
        		int n = Integer.parseInt(sc.nextLine());
        		return n;
        	} catch(NumberFormatException e) {
        		System.out.print("정수 입력> ");
        	}
    	}
    }

}