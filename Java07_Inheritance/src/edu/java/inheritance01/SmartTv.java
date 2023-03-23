package edu.java.inheritance01;

// 스마트TV는 TV이다. 스마트TV는 기본TV를 확장한다.
public class SmartTv extends BasicTv {
	
	private String ip;
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
