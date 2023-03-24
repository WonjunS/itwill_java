package edu.java.mvc.menu;

public enum Menu {
	
	EXIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	
	public static Menu getValue(int index) {
		Menu[] menus = Menu.values();
		if(index >= 0 && index < menus.length) {
			return menus[index];
		}
		return menus[menus.length - 1];
	}
	
}