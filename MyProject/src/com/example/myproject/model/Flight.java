package com.example.project.model;

import java.io.Serializable;

public class Flight implements Serializable {
	
	public interface Entity {
		String TBL_NAME = "FLIGHT";
		String COL_FLIGHT_ID = "FLIGHT_ID";
		String COL_FLIGHT_NO = "FLIGHT_NO";
		String COL_DEPT_TIME = "DEPT_TIME";
		String COL_DEST_TIME = "DEST_TIME";
		String COL_FLIGHT_TIME = "FLIGHT_TIME";
		String COL_CAPACITY = "CAPACITY";
	}
	
	private int flightId;
	private String flightNo;
	private String deptTime;
	private String destTime;
	private String flightTime;
	private int capacity;
	
	public int getFlightId() {
		return flightId;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getDeptTime() {
		return deptTime;
	}
	
	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}
	
	public String getDestTime() {
		return destTime;
	}
	
	public void setDestTime(String destTime) {
		this.destTime = destTime;
	}
	
	public String getFlightTime() {
		return flightTime;
	}
	
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
