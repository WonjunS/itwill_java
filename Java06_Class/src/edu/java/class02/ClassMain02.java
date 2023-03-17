package edu.java.class02;

public class ClassMain02 {
	
	public static void main(String[] args) {
		// TV 객체 사용 - TV 켬/끔, 채널 변경, 볼륨 변경, ...
		// (1) TV 객체를 생성
		BasicTv tv1 = new BasicTv(); // 생성자 호출 -> 객체 생성 
		
		// (2) 생성된 TV 객체(인스턴스)의 필드 또는 메서드를 사용
		// tv1.powerOn: 생성된 객체(인스턴스) tv1의 필드(멤버 변수) powerOn
		System.out.println("tv1 전원: " + tv1.powerOn);
		tv1.powerOnOff(); // 객체의 메서드 호출
		
		System.out.println("tv1 채널: " + tv1.channel);
		System.out.println("tv1 음량: " + tv1.volume);
		
		for(int i = 0; i < 10; i++) {
			tv1.channelUp();
		}
		
		System.out.println("--------");
		
		for(int i = 0; i < 10; i++) {
			tv1.channelDown();
		}

		System.out.println("--------");
		
		for(int i = 0; i < 7; i++) {
			tv1.volumeUp();
		}

		System.out.println("--------");
		
		for(int i = 0; i < 7; i++) {
			tv1.volumeDown();
		}
		
		
//		tv1.channelUp(); // channel: 0 -> 1
//		tv1.channelUp(); // channel: 1 -> 2
//		tv1.channelDown(); // channel 2 -> 1
//		
//		tv1.volumeUp(); // volume: 0 -> 1
//		tv1.volumeDown(); // volume: 1 -> 0
//		
//		tv1.powerOnOff();
//		
//		BasicTv tv2 = new BasicTv();
//		System.out.println("tv2 전원: " + tv2.powerOn);
//		tv1.powerOnOff();
	}

}
