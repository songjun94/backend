package com.local_global;

public class Animal {
	int age; //static 키워드가 붙지 않았기 때문에 인스턴스 변수
	static String kind; //static 변수
	
	void instanceMethod() { //인스턴스 메서드
//		System.out.println(age); // age는 인스턴스 변수이기 때문에 접근 가능.
		//인스턴스 메서드를 호출한다는 것은 객체가 이미 생성되었다는 것이기 때문에
		
//		System.out.println(kind);
	}
	
	static void staticMethod() {
//		System.out.println(age);
		//static 영역에 staticMethod()가 올라갈 시점에는 인스턴스가 생성되지 않았을 수 있기 때문에 접근 불가능.
		
		System.out.println(kind); //둘다 static 키워드가 있기 때문에 가능
//		instanceMethod(); age와 마찬가지
		
		// 만약 여기서 객체(인스턴스)를 생성한다면?
		Animal a = new Animal(); // static 메서드 내부라고 할지라도, 객체가 생성되었기 때문에
//		그다음 시점 라인에서는 접근이 가능해짐
//		a.instanceMethod();
		
	}
}
