package com.example.project.model;

import java.io.Serializable;

public class Reservation implements Serializable {
	
	public interface Entity {
		String TBL_NAME = "RESERVATION";
		String COL_RES_ID = "RES_ID";
		String COL_RES_NO = "RES_NO";
		String COL_ADULT = "ADULT";
		String COL_CHILD = "CHILD";
		String COL_TOTAL_PRICE = "TOTAL_PRICE";
		String COL_FLIGHT_NO = "FLIGHT_NO";
		String COL_MEMBER_ID = "MEMBER_ID";
	}
	
	private int resId;
	private String resNo;
	private int adultCount;
	private int childCount;
	private double totalPrice;
	
	private String flightNo;
	private int memberId;

}
