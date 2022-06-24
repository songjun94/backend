package com.local_global;

public class App {

	public static void main(String[] args) {
		//static 키워드가 부터있는 맴버는 프로그램 동작시 바로 메모리(static area)에 등록되기 때문에
//		인스턴스(Mouse)를 생성하기 전에도 접근(사용)가능하다.
//		해당 클래스 이름으로 곧바로 접근가능
		System.out.println(Mouse.countOfTail);
	
	Mouse jerry = new Mouse();
	System.out.println(jerry.countOfTail);
	
	Mouse mickey = new Mouse();
	jerry.countOfTail = 2;
	System.out.println("미키의 꼬리 :" + mickey.countOfTail);
	
	}
}
