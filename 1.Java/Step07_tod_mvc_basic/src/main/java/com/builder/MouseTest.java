package com.builder;

public class MouseTest {

	public static void main(String[] args) {
	
//		//제리가 키가 몇 센치 였더라
//		Mouse jerry = new Mouse("제리", null, "갈색", 2, 0);
//		
//		//점층적 생성자 패턴
//		Mouse jay = new Mouse();
//		System.out.println(jay);
//		
//		Mouse jamie = new Mouse("제이미");
//		System.out.println(jamie);
//		
//		//이름과 주소를 알고 있을 때
//		Mouse jayz = new Mouse("제이미", "s");
//		System.out.println(jayz);
//		
		//빌더 패턴
		
		//Builder 클래스로 생성한 인스턴스
//		new Mouse.Builder("제리")
		
		//이것도 Builder 클래스로 생성한 인스턴스(반환타입이 this니까)
//		new Mouse.Builder("제리").address("하와이")
		
		Mouse jerry = new Mouse.Builder("제리").address("하와이").height(50).build();
		System.out.println(jerry);
		
		
		
		
	}

}
